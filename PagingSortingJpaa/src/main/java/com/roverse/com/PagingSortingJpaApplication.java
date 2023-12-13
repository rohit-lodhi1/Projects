package com.roverse.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.roverse.com.entity.Employee;
import com.roverse.com.repositry.IEmployeeRepository;

@SpringBootApplication
public class PagingSortingJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagingSortingJpaApplication.class, args);
		
	}

}
