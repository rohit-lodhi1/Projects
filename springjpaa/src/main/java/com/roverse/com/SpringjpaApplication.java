package com.roverse.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.roverse.com.service.IEmployeeReposetry;

@SpringBootApplication
public class SpringjpaApplication {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(SpringjpaApplication.class, args);
		 IEmployeeReposetry emp =ac.getBean(IEmployeeReposetry.class);
		
		 System.out.println(emp);
	}

}
