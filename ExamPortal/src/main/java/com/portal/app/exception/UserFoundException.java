package com.portal.app.exception;

public class UserFoundException extends Exception {
	
	public UserFoundException(){
		super("User is Already Present");
	}
	
    public UserFoundException(String msg) {
    	super(msg);
    }
}
