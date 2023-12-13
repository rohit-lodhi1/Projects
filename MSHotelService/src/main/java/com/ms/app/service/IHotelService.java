package com.ms.app.service;

import java.util.List;

import com.ms.app.entites.Hotel;

public interface IHotelService {

	public Hotel addHotel(Hotel hotel);
	
	public Hotel getHotel(String id);
	
	public List<Hotel> getAllHotels();
	
	public void deleteHotel(String id);
	
}
