package com.web.app.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
  public static void main(String[] args) {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	  System.out.println(encoder.encode("Rohit"));
	//  $2a$10$qYmJpMNUsd6ImaLsO.5xUeKX0wiQCdl1nLBJS/76x.iHhxBfgCgou
	//  $2a$10$NnIH/8qLRvaMkVbk55ejN.tYHDOl/OtPE5u8uShgD0ksh0JNp3sQa
}
}
