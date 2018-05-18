package com.example.demo;



import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*某一接口具体实现类的选择控制权从调用类中移除，转交给第三方决定，即由Spring容器借由Bean配置来进行控制
让调用类对某一接口实现类的依赖关系由第三方（容器或协作类）注入，以移除调用类对某一接口实现类的依赖
*/
@SpringBootApplication  //结合@EnableAutoConfiguration、@ComponentScan、@Configuration的一个注解
@EnableTransactionManagement //相当于XML中的<tx:annotation-driven/>配置方式
@MapperScan("com.example.demo.mapper") //或者直接在每个Mapper类添加@Mapper注解
public class DemoApplication extends SpringBootServletInitializer{ //继承Spring Boot提供的Servlet初始化器

	@Bean //自定义事务管理器
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	//重写configure方法
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        //application.initializers(MyApplicationContextInitializer1,MyApplicationContextInitializer2);
        //application.listeners(MyApplicationListener1,MyApplicationListener2)
        return application.sources(DemoApplication.class);
    }

	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
