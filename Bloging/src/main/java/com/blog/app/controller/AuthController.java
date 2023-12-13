package com.blog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.entity.User;
import com.blog.app.entity.helper.LoginData;
import com.blog.app.entity.payload.UserRequest;
import com.blog.app.entity.payload.UserResponse;
import com.blog.app.service.IUserService;
import com.blog.app.util.JWTUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private IUserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtils jwtUtils;

	// To Add User
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		ResponseEntity<User> response = new ResponseEntity<User>(this.userService.addUser(user), HttpStatus.CREATED);
		return response;
	}

	// To Login User By UserName And Password
	@PostMapping("/signin")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest) {
		this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userRequest.getUserName(), userRequest.getPassword()));
		String token = jwtUtils.generateToken(userRequest.getUserName());
		return new ResponseEntity<UserResponse>(new UserResponse(token, "ROhit Created"), HttpStatus.ACCEPTED);
	}

	
	
}
