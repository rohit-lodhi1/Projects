package com.commerce.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.app.Service.IUserService;
import com.commerce.app.entities.User;
import com.commerce.app.entities.payload.UserRequest;
import com.commerce.app.entities.payload.UserResponse;
import com.commerce.app.exception.UserFoundException;
import com.commerce.app.utils.JWTUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	@PostMapping("/save")
	public ResponseEntity<User> addUser(@RequestBody User user){
     	ResponseEntity<User>  response=	new ResponseEntity<User>(this.userService.addUser(user),HttpStatus.OK);
		return response;
	}


	@PostMapping("/login")
	public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest user){
     	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
     	
     	UserResponse response = new UserResponse(jwtUtils.generateToken(user.getUserName()),"Created by Rohit");
     	
     	return new ResponseEntity<UserResponse>(response,HttpStatus.ACCEPTED);
     	
		
	}

	
}
