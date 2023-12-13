package com.blog.app.Exceptions;

public class PhotosNotFoundException  extends RuntimeException{

	public PhotosNotFoundException() {}
	public PhotosNotFoundException(String msg) {super(msg);}

}
