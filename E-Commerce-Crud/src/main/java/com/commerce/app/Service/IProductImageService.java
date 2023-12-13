package com.commerce.app.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.commerce.app.entities.ProductImage;

public interface IProductImageService {
  
	public ProductImage addImage(MultipartFile image) throws IOException;
	
	public List<ProductImage> getAllImages();
	
	public List<ProductImage> getAllImagesByProduct(Integer pid);
	
	public byte[] getImageById(Long id);
}
