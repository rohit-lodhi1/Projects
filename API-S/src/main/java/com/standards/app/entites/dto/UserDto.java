package com.standards.app.entites.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Integer id;
	
	
	@NotEmpty
	@Size(min = 4 , message = "User Name must be of 4 characters",max = 50)
	private String userName;
	@NotEmpty
	private String passowrd;
	@NotEmpty
	@Email( message = "Email is not valid !!! ")
	private String email;
	@NotNull
	private String mobileNo;
}
