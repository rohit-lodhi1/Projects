package com.security.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.config.JwtTokenUtil;
import com.security.app.entity.LoginRequest;
import com.security.app.entity.LoginResponse;
import com.security.app.entity.User;
import com.security.app.entity.UserRegistrationRequest;
import com.security.app.entity.UserRegistrationResponse;
import com.security.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        // Validate registration data, e.g., check if the username or email already exists

        // Create a new user
        User newUser = new User();
        newUser.setUsername(registrationRequest.getUsername());
        newUser.setPassword(registrationRequest.getPassword());
        newUser.setEmail(registrationRequest.getEmail());

        // Save the user in the database
        User savedUser = userService.save(newUser);

        // Generate a JWT token
        String token = generateToken(savedUser.getId());

        // Create a response object with the token
        UserRegistrationResponse response = new UserRegistrationResponse(savedUser.getId(), token);

        // Return the response with a success status
        return ResponseEntity.ok(response);
    }

    private String generateToken(Long userId) {
        // Generate a token using the JwtTokenUtil
        Map<String, Object> claims = new HashMap();
        // Add any additional claims you want to include in the token
        // For example, you can add roles or permissions
        return jwtTokenUtil.generateToken(userId.toString(), claims,10L);
    }
    
    private String generateToken(String username) {
        // Generate a token using the JwtTokenUtil
        Map<String, Object> claims = new HashMap();
        // Add any additional claims you want to include in the token
        // For example, you can add roles or permissions
        return jwtTokenUtil.generateToken(username);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        // Authenticate the user (e.g., verify the username and password)
        // If authentication fails, return an appropriate response or exception

        // Generate a JWT token
        String token = generateToken(loginRequest.getUsername());

        // Create a response object with the token
        LoginResponse response = new LoginResponse(token);

        // Return the response with a success status
        return ResponseEntity.ok(response);
    }
    @GetMapping("/verify")
    public ResponseEntity<String> checkAfterToken(){
    	return new ResponseEntity<String>("Done",HttpStatus.SEE_OTHER);
    }
}
