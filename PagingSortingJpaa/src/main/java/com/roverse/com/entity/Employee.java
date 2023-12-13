package com.roverse.com.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
	@Column(name="name")
   private String name;
	@Column(name="email")
   private String email;
	@Column(name="salary")
   private int salary;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	@JoinColumn(name = "dep_id")
	private Department depId;
}
