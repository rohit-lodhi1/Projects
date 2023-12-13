package com.roverse.com.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Lob
	 private byte[] image;
	
	
	private String name;
	
	private String path;
	
	
}
