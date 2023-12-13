package com.standards.app.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.standards.app.apiResponse.ApiResponse;
import com.standards.app.exception.ResourceNotFoundException;

import jakarta.el.MethodNotFoundException;

@RestControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception){
		return new ResponseEntity<ApiResponse>(new ApiResponse(exception.getMessage(),false),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , String>> methodArgsNotValidException(MethodArgumentNotValidException exception){
    	 Map<String, String> response = new HashMap<>();
    	 exception.getBindingResult().getAllErrors().forEach((err)->{
    		 String field = ((FieldError)err).getField();
    		 String msg = err.getDefaultMessage();
    		 response.put(field, msg);
    	 });
    	 return new ResponseEntity<Map<String,String>>(response,HttpStatus.NOT_ACCEPTABLE);
    }

	
}
