package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.Contacts;
import com.example.demo.bean.People;
import com.example.demo.mapper.PeopleAndContactsMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private PeopleAndContactsMapper peopleAndContactsMapper;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void oneToManyTest() {
		List<People> peoples = peopleAndContactsMapper.findContactsById(1).getPeoples();
		for(People people:peoples) {
			System.out.println(people.getPeopleid());
			System.out.println(people.getName());
			
			System.out.println(people.getPhonenumber());
		}
	}
	

}
