package com.portal.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.app.entity.Feedback;
import com.portal.app.entity.Role;
import com.portal.app.entity.User;
import com.portal.app.entity.UserRole;
import com.portal.app.entity.payload.UserPayLoad;
import com.portal.app.services.IFeedbackService;
import com.portal.app.services.IUserServices;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
   @Autowired
	private IUserServices userService;
	@Autowired
   private BCryptPasswordEncoder bcryptPasswordEncoder;
   
	@Autowired
	private IFeedbackService feedService;
	
   //creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		//encoding password wit BCryptPasswordEncode
		user.setUserPassword(this.bcryptPasswordEncoder.encode(user.getUserPassword()));
		
		
		
		Role role = new Role();
		role.setRoleId(2L);
		role.setRoleName("NORMAL");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(userRole);

		return this.userService.createUser(user, userRoles);
	}
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable String userName) {
		return this.userService.getUser(userName);
	}
	@DeleteMapping("/{userID}")
	public Long deleteUser(@PathVariable Long userID) {
		return this.userService.deleteUser(userID);
	}
	
	@PutMapping("/")
	public User updateUser(@RequestBody UserPayLoad user) {
	  return this.userService.updateUser(user);	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return new ResponseEntity<List<User>>(this.userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<User>> getAllUsers(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		return new ResponseEntity<Page<User>>(this.userService.getAllUsers(pageNo, pageSize),HttpStatus.OK);
	}
	@GetMapping("/feedback/{pageNo}/{pageSize}")
	public ResponseEntity<Page<Feedback>> getFeedbacksByPage(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		return new ResponseEntity<Page<Feedback>>(this.feedService.getFeedback(pageNo, pageSize),HttpStatus.OK);
	}
	
	@PostMapping("/feedback/{uId}")
	public ResponseEntity<Feedback> submitFeedback(@PathVariable Long uId, @RequestBody Feedback feedback){
		 User user = this.userService.getUserById(uId);
		 feedback.setUser(user);
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	     Date date = new Date();
	     feedback.setDate(date);
	     System.out.println(user.getUserFirstName());
		return new ResponseEntity<Feedback>(this.feedService.submit(feedback),HttpStatus.OK);
	}

	
	
}
