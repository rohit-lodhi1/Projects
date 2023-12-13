package com.blog.app.service;

import java.util.List;

import com.blog.app.entity.Album;
import com.blog.app.entity.Photos;

public interface IAlbumService {
   
	public Album addAlbum(Album album);
	
	public List<Album> getAllAlbums();
	
	public Album getAlbumById(Long id);
	
	public Boolean deleteAlbumById(Long id);
	
	public List<Photos> getAllPhotosOfALbum(Long id);
	
	public Album updateAlbumById(Album Album ,Long id);
}
