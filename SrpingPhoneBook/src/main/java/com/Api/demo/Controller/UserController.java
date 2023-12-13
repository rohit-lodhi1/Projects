package com.Api.demo.Controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.Api.demo.Service.IUserService;
import com.Api.demo.entity.User;

@RestController
@RequestMapping("/PhoneBook/User")
public class UserController {
	String msg;
	User user;
	@Autowired
	IUserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody User user)
	{
		
		 Integer userId= userService.createUser(user);
		 if(userId!=0)
		  msg="User "+user.getUserId()+" registered\n"+user.toString();
		 
		 else
			 msg="User with Email "+user.getUserEmail()+" already exists";
		 return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId){
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
		
	}
	
	@GetMapping("/getUserList/{pageNumber}/{pageSize}")
	public ResponseEntity<Iterable<User>> getUserList(@PathVariable Integer pageNumber,@PathVariable Integer pageSize){
		return new ResponseEntity<Iterable<User>>(userService.getUserList(pageNumber,pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/loginUser/{email}/{password}")
	public ResponseEntity<String> loginUser(@PathVariable String email, @PathVariable String password){
		 user= userService.loginUser(email, password);
		 if(user!=null)
		  msg="User "+user.getUserId()+" logged in ";
		 
		 else
			 msg="Something went wrong";
		 
		 return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer id)
	{
		userService.deleteUserById(id);
		msg=id+" deleted!";
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user)
	{
		Integer userId=userService.createUser(user);
		
		return new ResponseEntity<String>("User "+userId+" updated",HttpStatus.OK);

	}

}
