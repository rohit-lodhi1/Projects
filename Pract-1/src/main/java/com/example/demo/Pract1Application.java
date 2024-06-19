package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Pract1Application {

	public static void main(String[] args) {
		SpringApplication.run(Pract1Application.class, args);
		RestTemplate restTemplate = new RestTemplate();
		for(int i=0;i<10;i++) {
			ResponseEntity<String> forObject = restTemplate.getForEntity("https://github.com/rohit-lodhi1",String.class);
			System.out.println(forObject.getStatusCodeValue());
		}
			
	}
	


}
