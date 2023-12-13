package com.blog.app.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.entity.Album;
import com.blog.app.entity.Photos;
import com.blog.app.service.IAlbumService;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

	@Autowired
	private IAlbumService albumService;
	
	
	// To Get ALl the Albums 
	@GetMapping("")
	public ResponseEntity<List<Album>> getAllAlbums(){
		ResponseEntity<List<Album>> response = new ResponseEntity<List<Album>>(this.albumService.getAllAlbums(),HttpStatus.OK);
		return response;
	}

	// To Get Album By ID
	@GetMapping("/{id}")
	public ResponseEntity<Album> getAlbumById(@PathVariable Long id){
		ResponseEntity<Album> response = new ResponseEntity<Album>(this.albumService.getAlbumById(id),HttpStatus.OK);
		return response;
	}
	
	// To Add Album
	@PostMapping("")
	public ResponseEntity<Album> addAlbum(@RequestBody Album album){
		ResponseEntity<Album> response = new ResponseEntity<Album>(this.albumService.addAlbum(album),HttpStatus.CREATED);
		return response;
	}
	
	// To Update  Albums By Id And Json 
	@PutMapping("/{id}")
	public ResponseEntity<Album> updateAlbumById(@RequestBody Album album,@PathVariable Long id){
		ResponseEntity<Album> response = new ResponseEntity<Album>(this.albumService.updateAlbumById(album,id),HttpStatus.CREATED);
		return response;
	}
	
	// To Delete Album By ID 
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAlbumById(@PathVariable Long id){
		ResponseEntity<String> response = new ResponseEntity<String>(this.albumService.deleteAlbumById(id)+"Delete album id: "+id,HttpStatus.ACCEPTED);
		return response;
	}
	
	// To Get All the photos of album by ALbum ID
	@GetMapping("/{id}/photos")
	public ResponseEntity<List<Photos>> getAllPhotosOfAlbum(@PathVariable Long id){
		ResponseEntity<List<Photos>> response = new ResponseEntity<List<Photos>>(this.albumService.getAllPhotosOfALbum(id),HttpStatus.OK);
		return response;
	}
}
