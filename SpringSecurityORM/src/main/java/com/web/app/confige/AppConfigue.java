package com.web.app.confige;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfigue {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		System.out.println("app configu --  PassowrdEncoder()");
		
		return new BCryptPasswordEncoder();
	}
}
