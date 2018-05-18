package com.example.demo.bean;

public class People {
	private int peopleid;
	private String name;
	private int phonenumber;
	private Contacts contacts;
	public int getPeopleid() {
		return peopleid;
	}
	public void setPeopleid(int peopleid) {
		this.peopleid = peopleid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Contacts getContacts() {
		return contacts;
	}
	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}
	
}
