package com.roverse.entity;

public class User {
 private int ID;
 private String name,email,password,address,profileImg;
 
public User(String name, String email, String password, String address) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.address = address;
	this.profileImg ="user.png";
}
public User() {}
public String getName() {
	return name;
}
public String getProfileImg() {
	return profileImg;
}
public void setProfileImg(String profileImg) {
	this.profileImg = profileImg;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 
}
