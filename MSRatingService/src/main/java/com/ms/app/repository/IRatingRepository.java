package com.ms.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.app.entities.Rating;

public interface IRatingRepository extends JpaRepository<Rating, String>{
    public List<Rating> findByUserId(String userId);
    
    public List<Rating> findByHotelId(String hotelId);
    
    
}
