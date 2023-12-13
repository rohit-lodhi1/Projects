package com.roverse.com.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.roverse.com.entity.Department;
import com.roverse.com.entity.Employee;
import com.roverse.com.repositry.IDepartmentRepository;
import com.roverse.com.repositry.IEmployeeRepository;

//@Component
public class RelationMappingRunner implements CommandLineRunner {
@Autowired
private IEmployeeRepository eRepo;
@Autowired
private IDepartmentRepository dRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
	    
	    

	}

}
