package com.ms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.app.entities.Rating;

import com.ms.app.services.IRatingServices;


@RestController
@RequestMapping("/api/ratings")
public class RatingController {

	@Autowired
	private IRatingServices ratingService;
	
	// Creating user
	@PostMapping
	public ResponseEntity<Rating> addUser(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(this.ratingService.addRating(rating),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getUserById(@PathVariable String ratingId){
		return new ResponseEntity<Rating>(this.ratingService.getRating(ratingId),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return new ResponseEntity<List<Rating>>(this.ratingService.getAllRating(),HttpStatus.OK);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByHotelId(hotelId),HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByUserId(userId),HttpStatus.OK);
	}
}
