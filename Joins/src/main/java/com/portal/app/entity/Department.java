package com.portal.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer dId;
   private String dName;
   private String dCode;
public Department(String dName, String dCode) {
	super();
	this.dName = dName;
	this.dCode = dCode;
}
   
}
