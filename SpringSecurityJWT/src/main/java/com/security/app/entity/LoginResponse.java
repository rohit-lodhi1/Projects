package com.security.app.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;

    // Constructors, getters, and setters
    public static void main(String[] args) {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println(b.matches("rohitlodhi", "$2a$10$P3lkct5hedS4mSiXHPC7j.E1a4XCUWlgT6xPw9BJZ/5.HBCNohpMq"));
    	
	}
}
