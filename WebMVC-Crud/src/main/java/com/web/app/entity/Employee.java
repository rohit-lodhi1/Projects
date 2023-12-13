package com.web.app.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

import org.springframework.core.annotation.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eId;
    
	private Integer eSalary;
	private String empName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@ElementCollection
	@CollectionTable(name="emp_projects")
	@OrderColumn(name="pos")
	private List<String> projects;
	
	@ElementCollection
	@CollectionTable(name="codes")
	@MapKeyColumn(name="code")
	private Map<String , Integer> codes;
}
