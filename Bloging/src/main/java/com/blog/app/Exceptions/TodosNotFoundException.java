package com.blog.app.Exceptions;

public class TodosNotFoundException extends RuntimeException{
	public TodosNotFoundException() {}
	
	public TodosNotFoundException(String msg) {super(msg);}
}
