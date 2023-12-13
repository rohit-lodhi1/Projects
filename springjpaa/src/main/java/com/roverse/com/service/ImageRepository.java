package com.roverse.com.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roverse.com.entity.ProductImage;

public interface ImageRepository  extends JpaRepository<ProductImage, Integer>{

}
