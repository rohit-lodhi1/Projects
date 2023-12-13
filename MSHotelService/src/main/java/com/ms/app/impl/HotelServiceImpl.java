package com.ms.app.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.app.entites.Hotel;
import com.ms.app.exceptions.ResourceNotFoundException;
import com.ms.app.repository.IHotelRepositroy;
import com.ms.app.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepositroy hotelRepo;
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		hotel.setId(UUID.randomUUID().toString());
		return this.hotelRepo.save(hotel);
	}

	@Override
	public Hotel getHotel(String id) {
               
		return this.hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel Not found with id : "+id));
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return this.hotelRepo.findAll();
	}

	@Override
	public void deleteHotel(String id) {
		// TODO Auto-generated method stub
		this.hotelRepo.deleteById(id);
	}

}
