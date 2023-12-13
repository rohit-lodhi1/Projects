package com.commerce.app.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.commerce.app.Repository.IProductImageRepository;
import com.commerce.app.Service.IProductImageService;
import com.commerce.app.entities.ImageUtil;
import com.commerce.app.entities.Product;
import com.commerce.app.entities.ProductImage;
import com.commerce.app.exception.ProductNotFoundException;

@Service
public class ProductImageImpl implements IProductImageService {

	@Autowired
	private IProductImageRepository imageRepo;
	
	@Override
	public ProductImage addImage(MultipartFile image) throws IOException {
		ProductImage pimage = new ProductImage();
		pimage.setImage(ImageUtil.compressImage(image.getBytes()));
		pimage.setName(image.getOriginalFilename());
		
		return this.imageRepo.save(pimage);
	}

	@Override
	public List<ProductImage> getAllImages() {
		// TODO Auto-generated method stub
		return this.imageRepo.findAll();
	}

	@Override
	public List<ProductImage> getAllImagesByProduct(Integer pid) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setPId(pid);
		List<ProductImage> images = this.imageRepo.findByProduct(product);
		return images;
	}

	@Override
	public byte[] getImageById(Long id) {
		Optional<ProductImage> image = this.imageRepo.findById(id);
		if(image.isPresent())
			return ImageUtil.decompressImage(image.get().getImage());
		throw new ProductNotFoundException("Product Image Not Found id : "+id);
	}

}
