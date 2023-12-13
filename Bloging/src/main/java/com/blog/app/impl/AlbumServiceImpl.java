package com.blog.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.Exceptions.AlbumNotFoundException;
import com.blog.app.Exceptions.PhotosNotFoundException;
import com.blog.app.entity.Album;
import com.blog.app.entity.Photos;
import com.blog.app.repository.IAlbumRepository;
import com.blog.app.service.IAlbumService;

@Service
public class AlbumServiceImpl implements IAlbumService{

	@Autowired
	private IAlbumRepository albumRepo;
	
	//  To Add Album
	@Override
	public Album addAlbum(Album album) {
		return this.albumRepo.save(album);
	}

	// To Get All Albums
	@Override
	public List<Album> getAllAlbums() {
		System.out.println("pahuch gya bhai");
		return this.albumRepo.findAll();
	}

	// To Get Album by Id
	@Override
	public Album getAlbumById(Long id) {
		 Album album = this.albumRepo.findById(id).orElseThrow(()->new AlbumNotFoundException("Album not Found with Id : "+id));
		    return album;
	}

	// To Delete Album by ID 
	@Override
	public Boolean deleteAlbumById(Long id) {
		if(this.albumRepo.existsById(id)) {
			this.albumRepo.deleteById(id);
			return true;
		}
		throw new AlbumNotFoundException("Album not Found with Id : "+id);
	}

	// To Get all photos of Album by ALbum ID
	@Override
	public List<Photos> getAllPhotosOfALbum(Long id) {
		 Album album = this.albumRepo.findById(id).orElseThrow(()->new PhotosNotFoundException("Album not Found with Id : "+id));
		    return album.getPhotos();
	}

	// update album 
	@Override
	public Album updateAlbumById(Album album, Long id) {
		  if(this.albumRepo.existsById(id)) {
			  album.setId(id);
			 return this.albumRepo.save(album);
		  }
		throw new AlbumNotFoundException("Album not Found With Id : "+id);
	}

}
