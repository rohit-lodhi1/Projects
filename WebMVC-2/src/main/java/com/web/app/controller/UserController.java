package com.web.app.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.app.entity.User;

@Controller
public class UserController {
  
	@GetMapping("/home")
	public String getHome(ModelMap model ) {
		
		model.addAttribute("uName", "Rohit");
		model.addAttribute("uId", 1);
		model.addAttribute("uRole", "CONQUERE");
		
		System.out.println("Entered");
		return "userHome";
	}
	
	@GetMapping("/data")
	public String showUserObject(Model model) {
		model.addAttribute("user", new User(1,"SUmit","User"));
		model.addAttribute("list", Arrays.asList(new User(2,"OK","Alright"),new User(2,"hello","FUck"),new User(2,"NO","Yes")));
		return "userData";
	}
	
	
	
	public String showData() {
		
		return "userData";
	}
}
