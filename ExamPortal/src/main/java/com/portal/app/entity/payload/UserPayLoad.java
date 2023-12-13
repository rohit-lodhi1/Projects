package com.portal.app.entity.payload;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class UserPayLoad {


	private Long userId;


	private String userName;


	private String userEmail;


	private String userPassword;


	private String userFirstName;


	private String userLastName;


	private String userMobile;

 
	private boolean enabled = true;
	
	private String profileIMG = "default.png";

}
