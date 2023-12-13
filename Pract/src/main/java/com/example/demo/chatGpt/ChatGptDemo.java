package com.example.demo.chatGpt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ChatGptDemo {
	   @Autowired
	    private RestTemplate restTemplate=new RestTemplate();

	    @Value("${openai.api.key}")
	    private String apiKey;
	
	  public String sendPrompt(String prompt) {
	        String apiUrl = "https://api.openai.com/v1/chat/completions";
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "Bearer " + "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");
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        String requestBody = "{\"model\": \"davinci\", \"prompt\": \"" + prompt + "\"}";
	        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

	        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

	        if (response.getStatusCode() == HttpStatus.OK) {
	        	System.out.println(response.getBody());
	            return response.getBody();
	        } else {
	            throw new RuntimeException("Failed to send prompt to ChatGPT. Status code: " + response.getStatusCode());
	        }
	    }

}
