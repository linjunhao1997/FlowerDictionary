package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.Contacts;

public interface PeopleAndContactsMapper {
	
	Contacts findContactsById(@Param("contactsid") int contactsid);
}
