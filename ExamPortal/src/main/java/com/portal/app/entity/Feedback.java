package com.portal.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fId;
	private String message;
	
	private String email;
	
	private Date date;
	
	private String rating;
	
	@ManyToOne
	private User user;
	
	
}
