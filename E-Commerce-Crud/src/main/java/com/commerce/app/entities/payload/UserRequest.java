package com.commerce.app.entities.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  
	private String userName;
	
	private String password;
}
