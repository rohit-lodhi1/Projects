package com.blog.app.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
	
	private String street;
	
	private String suite;
	
	private String city;
	
	private String zipCode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="geo_id")
	private Geo geo;
	
private Timestamp createdAt;
	
	private Timestamp updatedAt;	
	
	private Long createdBy;
	private Long updatedBy; 
}
