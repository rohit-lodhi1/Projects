package com.blog.app.Exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {}
	public UserNotFoundException(String msg) {super(msg);}

}
