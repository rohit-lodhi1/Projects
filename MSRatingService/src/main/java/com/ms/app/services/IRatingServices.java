package com.ms.app.services;

import java.util.List;

import com.ms.app.entities.Rating;

public interface IRatingServices {

	public Rating addRating(Rating rating);
	
	public Rating getRating(String id);
	
	public List<Rating> getAllRating();
	
	public void deleteRating(String id);
	
	public List<Rating> getRatingByUserId(String userId);
	
	public List<Rating> getRatingByHotelId(String hotelId);
	
	
}
