package com.security.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.entity.User;
import com.security.app.payLoad.UserRequest;
import com.security.app.payLoad.UserResponse;
import com.security.app.service.IUserService;
import com.security.app.util.JWTUtils;

@RestController
@RequestMapping("/user")
public class AuthController {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtils jwtUtils;
	
	
	@PostMapping("/save")
	public ResponseEntity<User> regitration(@RequestBody User user){
		return new ResponseEntity<User>(this.userService.add(user),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) throws Exception{
		 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUserName(), userRequest.getPassword()));
			
		      return new ResponseEntity<UserResponse>(new UserResponse(jwtUtils.generateToken(userRequest.getUserName()),"Created by Rohit"),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> showUserDetail(Principal principal){
		System.out.println(principal.getClass().getName());
		return null;
	}
	
	@GetMapping("/customer")
	public ResponseEntity<String> customer(Principal principal){
		System.out.println(encoder.encode("Rohit"));
		System.out.println(principal.getName()+"jj");
		return null;
	}
	
}
