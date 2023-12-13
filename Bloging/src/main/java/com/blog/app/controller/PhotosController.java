package com.blog.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.app.entity.Photos;
import com.blog.app.service.IPhotosService;


@RestController
@RequestMapping("/api/photos")
public class PhotosController {
    
	@Autowired
	private IPhotosService photoService;
	
	// TO Add Photos
	@PostMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Photos> addPhotos(@RequestParam("image") MultipartFile image,@PathVariable Long id) throws IOException{
		ResponseEntity<Photos> response = new ResponseEntity<Photos>(this.photoService.addPhoto(image,id),HttpStatus.CREATED);
		return response;
	}
	
	
	// To Get All the photos
	@GetMapping
	public ResponseEntity<List<Photos>> getAllPhotos(){
		ResponseEntity<List<Photos>> response = new ResponseEntity<List<Photos>>(this.photoService.getAllPhotos(),HttpStatus.OK);
		return response;
	}
	
	// get photo by id
	@GetMapping("/{id}")
	public ResponseEntity<byte[]> getPhotoById(@PathVariable Long id){
		byte[] image = photoService.getPhotoById(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
	}
	
	// update photo by id
	@PutMapping("/{id}")
	public ResponseEntity<Photos> updatePhotoById(@PathVariable Long id,@RequestBody Photos photo){
		ResponseEntity<Photos> response = new ResponseEntity<Photos>(this.photoService.updatePhotoById(photo,id),HttpStatus.CREATED);
		return response;
	}
	// delete photo by id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePhotoById(@PathVariable Long id){
		ResponseEntity<String> response = new ResponseEntity<String>(this.photoService.deletePhotoById(id)+"Photo deleted Id : "+id,HttpStatus.CREATED);
		return response;
	}
	
}
