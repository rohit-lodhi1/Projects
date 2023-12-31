package com.commerce.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class ECommerceCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceCrudApplication.class, args);
	}

}
