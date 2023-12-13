package com.blog.app.Exceptions;

public class UserFoundException extends RuntimeException{
   
	public UserFoundException() {}
	
	public UserFoundException(String msg) {super(msg);}
}
