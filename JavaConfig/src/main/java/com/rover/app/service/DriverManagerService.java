package com.rover.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rover.app.bean.DriverManager;

@Component
public class DriverManagerService {
	
	@Autowired
	//@Qualifier("connectionObj")
    DriverManager con;

	@Override
	public String toString() {
		return "DriverManagerService [dob=" + con + "]";
	}

}
