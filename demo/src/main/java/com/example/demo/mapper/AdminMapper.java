package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.Admin;

public interface AdminMapper {
	/*
	 * 
	数据库是否存在该用户名和对应密码
	*/
	Admin isExist(@Param("adminname")String adminname,@Param("adminpw")String adminpw);
}
