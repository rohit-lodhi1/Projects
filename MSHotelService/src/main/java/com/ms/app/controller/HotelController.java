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

import com.ms.app.entites.Hotel;
import com.ms.app.service.IHotelService;


@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	@Autowired
	private IHotelService hotelServices;
	
	// Creating user
	@PostMapping
	public ResponseEntity<Hotel> addUser(@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(this.hotelServices.addHotel(hotel),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getUserById(@PathVariable String hotelId){
		return new ResponseEntity<Hotel>(this.hotelServices.getHotel(hotelId),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return new ResponseEntity<List<Hotel>>(this.hotelServices.getAllHotels(),HttpStatus.CREATED);
	}
}
