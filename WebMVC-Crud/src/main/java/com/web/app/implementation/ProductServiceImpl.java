package com.web.app.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.Exception.ProductNotFoundException;
import com.web.app.entity.Product;
import com.web.app.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	//@Autowired
//	private IProductRepository prodRepo;
	
	@Override
	public Product getProductById(Integer id) {

	 	 if(id==123) {
	 		 return new Product(id,"Pen","3000");
	 	 }else
	 		 throw new ProductNotFoundException("Product Not Found "+id);
		
		
	}

}
