package com.web.app.entities;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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
	private Integer id;
	
  private String userName;
  
  private String password;
  
  private String email;
	
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "userRoles" )
  @JoinColumn(name = "u_id")
  private Set<String> userRoles;
  
}
