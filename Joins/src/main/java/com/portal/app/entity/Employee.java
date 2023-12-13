package com.portal.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer eId;
   
   private String eName;
   
   private Double eSalary;
   
   public Employee(String eName, Double eSalary, Department department) {
	super();
	this.eName = eName;
	this.eSalary = eSalary;
	this.department = department;
}

@ManyToOne
   @JoinColumn(name="dpt_id")
   private Department department;
}
