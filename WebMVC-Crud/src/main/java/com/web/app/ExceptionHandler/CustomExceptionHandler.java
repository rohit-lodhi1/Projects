package com.web.app.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.web.app.Exception.ProductNotFoundException;
import com.web.app.error.MyErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
   
	public CustomExceptionHandler() {
		
	}
//	@ExceptionHandler(ProductNotFoundException.class)
//	public ResponseEntity<String> showCustomErrorMessage(ProductNotFoundException e){
//		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<MyErrorResponse> showCustomError(ProductNotFoundException m){
	 return new ResponseEntity<MyErrorResponse>(new MyErrorResponse(new Date().toString(),"Exception in process",500,m.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
