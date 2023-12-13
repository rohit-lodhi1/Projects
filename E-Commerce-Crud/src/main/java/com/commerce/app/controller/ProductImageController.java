package com.commerce.app.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.commerce.app.Service.IProductImageService;
import com.commerce.app.entities.ProductImage;

@RestController
@RequestMapping("/images")
public class ProductImageController {
 
	@Autowired
	private IProductImageService imageService;
	
	@PostMapping(value = "/",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ProductImage> addImage(@RequestParam("image") MultipartFile image) throws IOException{
	
		ResponseEntity<ProductImage> response = new ResponseEntity<ProductImage>(this.imageService.addImage(image),HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImageById(@PathVariable Long id){
		byte[] image = imageService.getImageById(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<ProductImage>> getImageOfProduct(@PathVariable Integer id) throws IOException{
		ResponseEntity<List<ProductImage>> response = new ResponseEntity<List<ProductImage>>(this.imageService.getAllImagesByProduct(id),HttpStatus.CREATED);
		return response;
	}
	
}
