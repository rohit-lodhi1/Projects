package com.roverse.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApiTryApplication {

	public static void main(String[] args) {
ApplicationContext ac=SpringApplication.run(ApiTryApplication.class, args);
	System.out.println(ac);
	}

}
