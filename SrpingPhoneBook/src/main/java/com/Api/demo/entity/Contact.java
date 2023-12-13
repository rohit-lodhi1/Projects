package com.Api.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer contactId;
	
	 @NotNull
	  @Size(min=3, message="Name should have atleast 2 characters")
	private String contactName;
	
	 
	private String contactEmail;
	
	 @NotNull
	  @Size(min=4, message="Address should have atleast 2 characters")
	private String contactAddress;
	 
	 
	private Long contactNumber;
	private Boolean isDeleted;
	private Boolean isFavourate;
	
	
	@UpdateTimestamp
	@DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime registrationDate;
	private Integer userId;
	
	
	
	

}
