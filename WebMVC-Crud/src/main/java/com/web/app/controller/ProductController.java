package com.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.app.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
  @GetMapping("/data")
  public String getHome(Model model) {
	  System.out.println("home");
	  model.addAttribute("product", new Product(1,"Pen","1234"));
	  return "Home";
  }
}
