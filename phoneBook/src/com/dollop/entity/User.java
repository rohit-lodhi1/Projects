package com.dollop.entity;

public class User {
	//private static int uId; 
	/*
	 * public static int getuId() { return uId; } public static void setuId(int uId)
	 * { User.uId = uId; }
	 */
String name,email,contact,address;
   private String password;
   
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
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String pssword) {
	this.password = pssword;
}

}
