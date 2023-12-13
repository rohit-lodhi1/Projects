package com.web.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="e_id")
	private Integer e_id;
	@Column(name="e_name")
	private String e_name;
	@Column(name="e_salary")
	private String e_salary;
	@Column(name="e_address")
	private String e_address;
}
