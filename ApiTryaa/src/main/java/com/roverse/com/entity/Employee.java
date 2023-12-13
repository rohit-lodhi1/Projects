package com.roverse.com.entity;


import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="EmployeeAPI")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="emp_name" , length = 255)
  private String name;
	@Column(name="emp_email" , length = 255)
  private String email;
  
 


}
