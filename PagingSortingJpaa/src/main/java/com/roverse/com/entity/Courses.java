package com.roverse.com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "std_courses")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  
  @ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
  @ElementCollection
  @JsonIgnore
  private List< Student> student;
}
