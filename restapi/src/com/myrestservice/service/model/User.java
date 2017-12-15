package com.myrestservice.service.model;

public class User {

	public String usrid;
	public String usrname;
	public int usrage;
	
	public User(String id, String name, int age ) {
		this .usrid=id;
		this.usrname = name;
		this.usrage = age;
		
	}
	
	/*Created for adding new user*/
	public User() {
		// TODO Auto-generated constructor stubs
	}
	/*ends here*/
	
	public User(String name) {
		// TODO Auto-generated constructor stub
	}

	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public int getUsrage() {
		return usrage;
	}
	public void setUsrage(int usrage) {
		this.usrage = usrage;
	}
}
