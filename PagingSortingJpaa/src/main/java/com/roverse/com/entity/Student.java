package com.roverse.com.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="std_info")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
		@Column(name="name")
	   private String name;
		@Column(name="email")
	   private String email;
		@Column(name="fee")
	   private int fee;
	
		
	    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "student")
	    @ElementCollection
	    @JsonIgnore
	    private List<Courses> courses;
		
		
	
		
}
