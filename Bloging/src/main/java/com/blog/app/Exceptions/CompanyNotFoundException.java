package com.blog.app.Exceptions;

public class CompanyNotFoundException extends RuntimeException{
   public CompanyNotFoundException() {}
   public CompanyNotFoundException(String msg) {super(msg);}
}
