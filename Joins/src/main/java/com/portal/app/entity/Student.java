package com.portal.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer sId;
     private String sName;
     
     @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
     private Address address;
     
}
