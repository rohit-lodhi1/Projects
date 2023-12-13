package com.ms.app.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   
	@Id
	private String id;
	
	private String name;
	
	private String email;
	
	private String mobileNo;
	
	@Transient
	private List<Ratings> ratings =  new ArrayList<>();
	
	
}
