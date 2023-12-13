package com.ms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.app.entites.Hotel;

public interface IHotelRepositroy  extends JpaRepository<Hotel, String>{

}
