package com.commerce.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	
	@Column(unique = true)
	private String username;
	
	private String email;
	
	private String password;
	
	private String accessToken;
	@CreatedDate
	private Date createdDate;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="roles")
	private List<String> roles;	
	
}
