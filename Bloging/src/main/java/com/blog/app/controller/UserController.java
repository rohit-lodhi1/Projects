package com.blog.app.controller;

import java.security.Principal;
import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.blog.app.entity.Album;
import com.blog.app.entity.Posts;
import com.blog.app.entity.User;
import com.blog.app.repository.IUserRepository;
import com.blog.app.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
 
	@Autowired
	private IUserService userService;
	
	// get current user 
	@GetMapping("/me")
	public ResponseEntity<User> me(Principal principal){
		 ResponseEntity<User> response = new ResponseEntity<User>(this.userService.findByUserName(principal.getName()),HttpStatus.OK);
		 return response;
	}
	
	
	// add user 
	 @PostMapping("")
     public ResponseEntity<User> addUser(@RequestBody User user)		{
		 ResponseEntity<User> response = new ResponseEntity<User>(this.userService.addUser(user),HttpStatus.CREATED);
		 return response;
	 }
	
	// To Get User By ID 
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		ResponseEntity<User> response = new ResponseEntity<User>(this.userService.getUserById(id),HttpStatus.CREATED);
		return response;
	}
	
	// To Update User
	@PutMapping("")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		ResponseEntity<User> response = new ResponseEntity<User>(this.userService.updateUser(user),HttpStatus.OK);
		return response;
	}
	
	// To Get Posts created by User By UserName 
	@GetMapping("/{userName}/posts")
	public ResponseEntity<List<Posts>> getPostsOfUser(@PathVariable String userName){
		  ResponseEntity<List<Posts>> response = new ResponseEntity<List<Posts>>(this.userService.getPostsOfUser(userName),HttpStatus.OK);
		  return response;
	}
	
	// To Get ALbums created by User By UserName
	@GetMapping("/{userName}/albums")
	public ResponseEntity<List<Album>> getAlbumsOfUser(@PathVariable String userName){
		  ResponseEntity<List<Album>> response = new ResponseEntity<List<Album>>(this.userService.getAlbumsOfUser(userName),HttpStatus.OK);
		  return response;
	}
    
    // To Check userName is Available or Not  
	@GetMapping("/checkUsernameAvailability")
	public ResponseEntity<Boolean> checkUsernameAvailability(@RequestBody String userName){
		  ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(this.userService.checkUsernameAvailability(userName),HttpStatus.OK);
		  return response;
	}
	
    // To Check Email is Available or Not
	@GetMapping("/checkEmailAvailability")
	public ResponseEntity<Boolean> checkEmailAvailability(@RequestBody String email){
		  ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(this.userService.checkEmailAvailability(email),HttpStatus.OK);
		  return response;
	}	
	
	//  delete user by userName
	@DeleteMapping("/{username}")
	public ResponseEntity<String> deleteUserByUserName(@PathVariable String username,Principal principal){
		  ResponseEntity<String> response = new ResponseEntity<String>(this.userService.deleteUserByUserName(username,principal)+"user Delted with user Name : "+username,HttpStatus.OK);
		  return response;
	}
	
	// make user admin by username
	@PutMapping("/{username}/giveAdmin")
	public ResponseEntity<String> giveAdmin(@PathVariable String username){
		ResponseEntity<String> response = new ResponseEntity<String>(this.userService.giveAdmin(username)?"you make admin to user ":"already admin "+username,HttpStatus.ACCEPTED);
		return response;
	}
	
    // take admin authority by username
	@PutMapping("/{username}/takeAdmin")
	public ResponseEntity<String> takeAdmin(@PathVariable String username){
		ResponseEntity<String> response = new ResponseEntity<String>(this.userService.takeAdmin(username)?"you remove admin to user ":"already removed "+username,HttpStatus.ACCEPTED);
		return response;
	}	
}
