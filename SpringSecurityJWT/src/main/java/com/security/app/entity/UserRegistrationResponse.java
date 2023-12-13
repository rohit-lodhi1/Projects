package com.security.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
	public class UserRegistrationResponse {
	    private Long userId;
	    private String token;

	    // Constructors, getters, and setters
	}

