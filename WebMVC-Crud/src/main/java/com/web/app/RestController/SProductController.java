package com.web.app.RestController;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class SProductController {
   
	
	@GetMapping("")
	public ResponseEntity<String> getProducts(){
		ResponseEntity<String> response = new ResponseEntity<>("From get Product",HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addProduct(){
		ResponseEntity<String> response = new ResponseEntity<>("From post Product",HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(){
		ResponseEntity<String> response = new ResponseEntity<>("From put Product",HttpStatus.OK);
		return response;
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteProduct(){
		ResponseEntity<String> response = new ResponseEntity<>("From delete Product",HttpStatus.OK);
		return response;
	}
	
	@PatchMapping("/update")
	public ResponseEntity<String> partiallyUpdate(){
		ResponseEntity<String> response = new ResponseEntity<>("From patch Product",HttpStatus.OK);
		return response;
	}
}
