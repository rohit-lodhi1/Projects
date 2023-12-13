package com.roverse.com.entity;


import java.util.ArrayList;
import java.util.Scanner;


import jakarta.persistence.*;
import lombok.Data;

@Table(name="EmployeeAPI")
@Entity
@Data
public class Employee  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="emp_name" , length = 255)
  private String name;
	@Column(name="emp_email" , length = 255)
  private String email;
  
public Employee(Integer id, String name, String email) {
	super();

	this.id = id;
	this.name = name;
	this.email = email;
}

}
