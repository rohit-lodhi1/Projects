package com.dollop.entity;

public class User {
private int id;
private String name,email,password,mobile,type;



public User(String name, String email, String mobile, String password,String type) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.type=type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobile() {
	return mobile;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}


}
