package com.Api.demo.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Api.demo.bean.ErrorMessage;
import com.Api.demo.exception.NotFoundException;

@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorMessage> showCustomeErrorMessage(NotFoundException nfe){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(new Date().toString(),"Exception in progress",505,nfe.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
