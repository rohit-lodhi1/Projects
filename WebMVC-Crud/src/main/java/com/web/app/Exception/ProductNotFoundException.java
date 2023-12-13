package com.web.app.Exception;

public class ProductNotFoundException extends RuntimeException{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
    	
    }
    
    public ProductNotFoundException(String msg) {
    	super(msg);
    }
    
}
