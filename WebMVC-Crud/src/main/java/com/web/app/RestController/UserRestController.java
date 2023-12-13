package com.web.app.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.Repository.UserRepository;
import com.web.app.entity.Student;
import com.web.app.entity.User;
import com.web.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
   
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestBody User user){
		ResponseEntity<User> response = new ResponseEntity<User>(this.userService.saveUser(user),HttpStatus.CREATED);
	  return response;
	}
	
	@GetMapping("")
	public ResponseEntity<List<User>> getUsers(){
		
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(this.userService.getUsers(),HttpStatus.OK);
		return response; 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
		ResponseEntity<User> response = new ResponseEntity<User>(this.userService.getUser(id),HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id){
		this.userService.deleteUser(id);
		ResponseEntity<String> response = new ResponseEntity<String>("Deleted "+id,HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		ResponseEntity<User> response = new ResponseEntity<User>(this.userService.updateUser(user),HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/roles")
	public ResponseEntity<Map<Integer, String>> getMappedRoles(){
		ResponseEntity<Map<Integer,String>> response = new ResponseEntity<Map<Integer,String>>(this.userService.getMappedRoles(),HttpStatus.OK);
				return response;
	}
	
	
	@DeleteMapping("/role/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Integer id){
		this.userService.deleteRole(id);
		return ResponseEntity.ok("Deleted");
	}
	
	
	@PostMapping("/student/")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		this.userRepo.save(student);
		System.out.println("alkdfja");
		return new ResponseEntity<>("Inseted",HttpStatus.OK);
	}
	
}
