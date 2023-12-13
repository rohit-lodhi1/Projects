package com.blog.app.Exceptions;

public class PostNotFoundException extends RuntimeException {
   
	 public PostNotFoundException() {}
	 public PostNotFoundException(String msg) {super(msg);}
}
