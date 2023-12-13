package com.dollop.entity;

public class User {

	private Integer id;
	private String name;
	private String email;
	private String passward;
private String role;

	
	public User( String name, String email, String passward,String role) {
		super();
	
		this.name = name;
		this.email = email;
		this.passward = passward;
        this.role=role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	
	
	
	
}
