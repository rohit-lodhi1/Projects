package com.Api.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
@OpenAPIDefinition
@SpringBootApplication
public class SrpingPhoneBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrpingPhoneBookApplication.class, args);
	}

}
