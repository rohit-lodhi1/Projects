package com.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		System.out.println("login");
		return "login";
	}
	
	@GetMapping("/hello")
	public String showHello() {
		System.out.println("hello");
		return "hello";
	}
	
	@GetMapping("/customer")
	public String showCustomer() {
		return "customer";
	}
	
	@GetMapping("/admin")
	public String showAdmin() {
		return "admin";
	}
	
	
}
