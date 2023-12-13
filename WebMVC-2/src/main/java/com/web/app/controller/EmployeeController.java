package com.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.app.entity.Employee;

@Controller
public class EmployeeController {
	//1. To display HTML Form inside browser
		// PATH: show, HTTP method : GET
		@GetMapping("/show")  
		public String showForm() {
			return "form";
		}
		
		
		//2. To Read data from HTML FORM (ModelAttribute)
		// PATH: register, HTTP method : POST
		@PostMapping("/register")
		public String readData(
				@ModelAttribute Employee employee,
				Model model
				) 
		{
			System.out.println(employee);
			model.addAttribute("obj",employee);
			return "EmpData";
		}
}
