package com.dollop.entity;

public class Contacts {

	 private Integer id;
	 private String name;
	 private String email;
	 private String mobileNo;
	 private Boolean isFavourite;
	 private Integer groupId;
	 private Integer uId;
	 
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Contacts( String name, String email, String mobileNo,Integer uId) {
		super();
		
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.uId=uId;
		this.groupId=0;
		this.isFavourite=false;
	}
	public Contacts() {
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Boolean getIsFavourite() {
		return isFavourite;
	}
	public void setIsFavourite(Boolean isFavourite) {
		this.isFavourite = isFavourite;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
}
