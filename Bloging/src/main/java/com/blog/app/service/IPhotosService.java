package com.blog.app.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.blog.app.entity.Comments;
import com.blog.app.entity.Photos;

public interface IPhotosService {
  
	public List<Photos> getAllPhotos();
	
	public byte[] getPhotoById(Long id);
	
	public Photos addPhoto(MultipartFile image, Long aid) throws IOException;
	
	public Photos updatePhotoById(Photos photo,Long id);
	
	public Boolean deletePhotoById(Long id);
}
