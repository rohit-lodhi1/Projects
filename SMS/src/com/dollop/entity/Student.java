package com.dollop.entity;

import java.io.Serializable;

public class Student implements Serializable {
     
	private Integer sId;
	private String sName;
	private String sEmail;
	private String sPassWord;
	private String sContact;
	private String sAddress;
	
	
	public Student() {
		super();
	}
	
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsPassWord() {
		return sPassWord;
	}
	public void setsPassWord(String sPassWord) {
		this.sPassWord = sPassWord;
	}
	public String getsContact() {
		return sContact;
	}
	public void setsContact(String sContact) {
		this.sContact = sContact;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	@Override
	public String toString() {
		return  sId  + sName + "" + sEmail + ""+ sPassWord
				 + sContact + "" + sAddress + "\n";
	}
    
	

}
