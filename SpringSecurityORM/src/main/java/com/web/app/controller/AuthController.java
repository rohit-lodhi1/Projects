package com.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.entities.User;
import com.web.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class AuthController {

	@Autowired
	private IUserService userService;
	
	@GetMapping
	public String home() {
	
		return "home";
	}
	
	@GetMapping("/showRegistration")
	public String showRegistration() {
		return "registration";
	}
	
	@PostMapping("/save")
	public String addUser(@ModelAttribute User user,Model model){
		model.addAttribute("message","User Registered with id : "+this.userService.addUser(user).getId());
	  return "registration";
	}
	
	
}
