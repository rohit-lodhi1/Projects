package com.blog.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.jboss.jandex.Main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
   private String name;
   
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private List<Posts> posts; 
	public static void main(String[] args) {
		
			
		
	}
}
