package com.standards.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.standards.app.entites.dto.UserDto;
import com.standards.app.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	@PostMapping("/save")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto){
		return new ResponseEntity<UserDto>(this.userService.createUser(userDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer id){
		return new ResponseEntity<UserDto>(this.userService.getUser(id),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> addUser(){
		return new ResponseEntity<List<UserDto>>(this.userService.getAllUsers(),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer id){
		return new ResponseEntity<UserDto>(this.userService.updateUser(userDto,id),HttpStatus.CREATED);
	}
	
}
