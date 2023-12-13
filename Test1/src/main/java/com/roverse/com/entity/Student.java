package com.roverse.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="StudentAPI")
@Entity
@Data
public class Student {
   @Id
   @Column(name="st_id")
	private int id;
   @Column(name="st_name")
	private String name;
   @Column(name="st_email")
	private String email;

	
}
