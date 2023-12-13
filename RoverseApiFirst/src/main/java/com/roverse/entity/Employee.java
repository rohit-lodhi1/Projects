package com.roverse.entity;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="EmployeeAPI")
@Entity
@Data
public class Employee  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="emp_name" , length = 255)
  private String name;
	@Column(name="emp_email" , length = 255)
  private String email;
  
public Employee(int id, String name, String email) {
	super();

	this.id = id;
	this.name = name;
	this.email = email;
}

}
