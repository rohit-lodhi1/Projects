package com.roverse.com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roverse.com.entity.Product;
import com.roverse.com.entity.Products;

public interface IProductRpository extends JpaRepository<Products, Integer>{
    
}
