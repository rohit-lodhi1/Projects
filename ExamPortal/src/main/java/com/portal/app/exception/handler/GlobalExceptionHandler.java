package com.portal.app.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.portal.app.exception.UserFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> userFoundException(UserFoundException ex){
		Map<String, String> response = new HashMap<>();
		response.put("message", ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
}
