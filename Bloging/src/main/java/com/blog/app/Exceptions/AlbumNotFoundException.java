package com.blog.app.Exceptions;

public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException() {};
    public AlbumNotFoundException(String msg) {super(msg);};
}
