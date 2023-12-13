package com.roverse.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Models {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="model_id")
   private Integer  id;
	@Column(name="model_cod")
   private String code;
   
}
