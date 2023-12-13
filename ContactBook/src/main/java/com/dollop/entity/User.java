package com.dollop.entity;

public class User {
	
String name,email,contact,image;
int id;
  private String password;
  
  
  
  public User(String name, String email, String contact, String password) {
	super();
	this.name = name;
	this.email = email;
	this.contact = contact;
	this.password = password;
	this.image="user.png";
}
public User() {
	// TODO Auto-generated constructor stub
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
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}

public String getPassword() {
	return password;
}
public void setPassword(String pssword) {
	this.password = pssword;
}

}
