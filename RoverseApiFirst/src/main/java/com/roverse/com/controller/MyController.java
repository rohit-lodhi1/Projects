package com.roverse.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roverse.com.services.IEmployeService;
import com.roverse.com.servicesImpl.EmployeServiceImpl;
import com.roverse.entity.Employee;

@RestController
public class MyController {
	@Autowired
    private IEmployeService emp;
	
	@GetMapping("/home")
	public String home() {
		return "Yuppyyyy!!!!";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return emp.getEmployees();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable String employeeId) {
		return emp.getEmployeeById(Integer.parseInt(employeeId));
	}
	
	@PostMapping("/employee")
	public Employee addCourse(@RequestBody Employee empl) {
		return emp.addEmployee(empl);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId) {
		try {
		     emp.deleteEmployeeByID(Integer.parseInt(employeeId));
		     return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	
	}
	
	@PutMapping("/employee")
	public int updateEmployee(@RequestBody Employee empl) {
		return emp.updateEmployee(empl);
	}
	
}
