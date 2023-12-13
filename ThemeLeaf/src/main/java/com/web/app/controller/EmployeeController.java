package com.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.app.Service.IEmployeeService;
import com.web.app.bean.Employee;

@Controller
public class EmployeeController {
  @Autowired
  private IEmployeeService empService;
  @GetMapping("")
  public String home(Model model) {
	  model.addAttribute("empList", this.empService.getEmpPage(0).getContent());
	  
	  return "home";
  }
  @GetMapping("/addEmployee")
  public String addPage(Model model) {
	  
	  model.addAttribute("Employee", new Employee());
	  return "addEmployee";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute Employee emp,Model model) {
	  this.empService.addEmployee(emp);
	  model.addAttribute("empList", this.empService.getEmpPage(0).getContent());
	  model.addAttribute("msg", "Saved Successfully");
	  return "home";
  }
  
  @GetMapping("/edit/{id}")
  public String editPage(@PathVariable("id") Integer id,Model model) {
	    model.addAttribute("emp", this.empService.getEmployeeById(id));
	   return "editEmployee";
  }
  
  @GetMapping("/delete/{id}")
  public String deleteEmployee(@PathVariable("id") Integer id,Model model) {
	  this.empService.deleteEmployee(id);
	  model.addAttribute("empList", this.empService.getEmpPage(0).getContent());
	  return "home";
  }
  @GetMapping("/data/{page}")
  public String getPagable(@PathVariable("page") Integer page,Model model) {
	  model.addAttribute("empList", this.empService.getEmpPage(page).getContent());
	  return "home";
  }
  
  
}
