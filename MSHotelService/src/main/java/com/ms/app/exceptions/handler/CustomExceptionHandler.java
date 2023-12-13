package com.ms.app.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ms.app.exceptions.ResourceNotFoundException;
import com.ms.app.exceptions.error.ApiResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception){
		ApiResponse apiResponse = ApiResponse.builder().success(true).status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
	    return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NO_CONTENT);
	}
	
}
