package com.web.app.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.entity.Employee;
import com.web.app.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		return new ResponseEntity<Employee>(this.empService.getEmployeeById(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<List<Employee>>(this.empService.getAllEmployees(),HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		this.empService.deleteEmployee(id);
		return new ResponseEntity<String>("Deleted ",HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(this.empService.save(employee),HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(this.empService.updateEmployee(employee),HttpStatus.OK);
	}
	
	
}
