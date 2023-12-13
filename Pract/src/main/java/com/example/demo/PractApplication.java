package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.chatGpt.ChatGptDemo;

@SpringBootApplication
public class PractApplication implements CommandLineRunner{
	   @Value("${openai.api.key}")
	    private String apiKey;

	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

	    public String getApiKey() {
	        return apiKey;
	    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(PractApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		ChatGptDemo g = new ChatGptDemo() ;
		g.sendPrompt("Hello what are you doing?");
		
	}

}
