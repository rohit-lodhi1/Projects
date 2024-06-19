package com.schedular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.schedular.bean.Schedular;

@Configuration
@EnableScheduling
public class SchedularConfig {
	
	@Bean
   public Schedular schedul() {
	   return new Schedular();
   }
	
	@Bean
 public	Rest restTemplate() {
		
	}
}
