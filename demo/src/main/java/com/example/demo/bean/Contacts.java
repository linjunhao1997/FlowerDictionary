package com.example.demo.bean;

import java.util.List;

public class Contacts {
	private int id;
	private int contactsid;
	private List<People> peoples;
	public int getContactsid() {
		return contactsid;
	}
	public void setContactsid(int contactsid) {
		this.contactsid = contactsid;
	}
	public List<People> getPeoples() {
		return peoples;
	}
	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
