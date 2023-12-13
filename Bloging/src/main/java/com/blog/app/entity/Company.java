package com.blog.app.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cachePharse;
	
	private String bs;
	
	  @CreationTimestamp
private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;	
	
	private Long createdBy;
	
	private Long updatedBy;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="c_id")
	@JsonIgnoreProperties("company")
	private List<User> users;
   
}
