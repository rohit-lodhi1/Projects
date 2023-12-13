package com.ms.app.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.app.entities.Rating;
import com.ms.app.exceptions.ResourceNotFoundException;
import com.ms.app.repository.IRatingRepository;
import com.ms.app.services.IRatingServices;

@Service
public class RatingServiceImpl implements IRatingServices{

	@Autowired
	private IRatingRepository ratingRepo;
	
	@Override
	public Rating addRating(Rating rating) {
         rating.setId(UUID.randomUUID().toString());
		return this.ratingRepo.save(rating);
	}

	@Override
	public Rating getRating(String id) {
		// TODO Auto-generated method stub
		return this.ratingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Rating not found with id : "+id));
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return this.ratingRepo.findAll();
	}

	@Override
	public void deleteRating(String id) {
		// TODO Auto-generated method stub
		this.ratingRepo.deleteById(id);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return this.ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return this.ratingRepo.findByHotelId(hotelId);
	}
	
	

}
