package com.dollop.entity;

public class Contacts {
	int id;
    int userId;
	private String name,email,address,mobile,date;
	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contacts(String name, String email,String mobile,String address) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public static boolean equals(Contacts c, Contacts c1) {
		String name1=c.name.toLowerCase();
		String name2=c1.name.toLowerCase();
		System.out.println(name1.charAt(0)+" "+name2.charAt(0));
		if(name1.charAt(0)<name2.charAt(0))
			return true;
		return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
