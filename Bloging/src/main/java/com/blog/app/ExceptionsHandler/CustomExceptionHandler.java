package com.blog.app.ExceptionsHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.app.Exceptions.AlbumNotFoundException;
import com.blog.app.Exceptions.CommentsNotFoundExceptions;
import com.blog.app.Exceptions.CompanyNotFoundException;
import com.blog.app.Exceptions.PhotosNotFoundException;
import com.blog.app.Exceptions.PostNotFoundException;
import com.blog.app.Exceptions.TodosNotFoundException;
import com.blog.app.Exceptions.UserFoundException;
import com.blog.app.Exceptions.UserNotFoundException;
import com.blog.app.Exceptions.error.ErrorMessage;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<ErrorMessage> userNameFound(UserFoundException u){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(u.getMessage(),"500","Exception in Signup",new Date().toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PhotosNotFoundException.class)
	public ResponseEntity<ErrorMessage> photosNotFound(PhotosNotFoundException u){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(u.getMessage(),"500","Exception in Fetching",new Date().toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AlbumNotFoundException.class)
	public ResponseEntity<ErrorMessage> albumNotFound(AlbumNotFoundException u){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(u.getMessage(),"500","Exception in Fetching",new Date().toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CommentsNotFoundExceptions.class)
	public ResponseEntity<ErrorMessage> commentNotFound(CommentsNotFoundExceptions u){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(u.getMessage(),"500","Exception in Fetching",new Date().toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFound(UserNotFoundException u){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(u.getMessage(),"500","Exception in Fetching",new Date().toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ErrorMessage> companyNotFound(CompanyNotFoundException u){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(u.getMessage(),"500","Exception in Fetching",new Date().toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public ResponseEntity<ErrorMessage> postNotFound(PostNotFoundException u){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(u.getMessage(),"500","Exception in Fetching",new Date().toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TodosNotFoundException.class)
	public ResponseEntity<ErrorMessage> todoNotFound(TodosNotFoundException u){
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(u.getMessage(),"500","Exception in Fetching",new Date().toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
