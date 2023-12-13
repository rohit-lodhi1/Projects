package com.commerce.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.app.entities.Product;
import com.commerce.app.entities.ProductImage;

public interface IProductImageRepository extends JpaRepository<ProductImage, Long>{
   public List<ProductImage> findByProduct(Product product);
}
