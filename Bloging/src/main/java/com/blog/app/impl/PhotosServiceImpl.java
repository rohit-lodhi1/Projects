package com.blog.app.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.app.Exceptions.PhotosNotFoundException;
import com.blog.app.entity.Album;
import com.blog.app.entity.Photos;
import com.blog.app.entity.helper.ImageUtil;
import com.blog.app.repository.IPhotosRepository;
import com.blog.app.service.IAlbumService;
import com.blog.app.service.IPhotosService;

@Service
public class PhotosServiceImpl implements IPhotosService{

	@Autowired
	private IPhotosRepository photosRepo;
	
	@Autowired
	private IAlbumService albumService;
	
    // To Get All the photos 	
	@Override
	public List<Photos> getAllPhotos() {
		return this.photosRepo.findAll();
	}

    // To Get photo By id 
	@Override
	public byte[] getPhotoById(Long id) {
		Photos photo = this.photosRepo.findById(id).orElseThrow(()-> new PhotosNotFoundException("Photo not found wiht Id : "+id));
			return ImageUtil.decompressImage(photo.getImage());	
	}

    // To Add  photo 
	@Override
	public Photos addPhoto(MultipartFile file , Long aid) throws IOException {
		Photos photo = new Photos();
		Album album = this.albumService.getAlbumById(aid);
		photo.setAlbum(album);
		photo.setTitle(file.getOriginalFilename());
		photo.setImage(ImageUtil.compressImage(file.getBytes()));
		return this.photosRepo.save(photo);
	}

	// To Update Photo By Id And Json 
	@Override
	public Photos updatePhotoById(Photos photo, Long id) {
        Photos photos = this.photosRepo.findById(id).orElseThrow(()->new PhotosNotFoundException("Photo not found wiht Id : "+id));
        	photo.setId(photos.getId());
        	return this.photosRepo.save(photo);  
	}
    
	// To delete Photo By Id
	@Override
	public Boolean deletePhotoById(Long id) {
		if(this.photosRepo.existsById(id)) {
			this.photosRepo.deleteById(id);
			return true;
		}
		throw new PhotosNotFoundException("Photo not found wiht Id : "+id);
	}

}
