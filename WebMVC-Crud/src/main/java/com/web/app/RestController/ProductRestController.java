package com.web.app.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.Exception.ProductNotFoundException;
import com.web.app.entity.Product;
import com.web.app.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private IProductService productService;
	
	
	
	@GetMapping("/{pid}")
public ResponseEntity<Product> getProductById(@PathVariable Integer pid){
		
		ResponseEntity< Product> response=null;
		try {
			Product product = this.productService.getProductById(pid);
			response= new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		catch(ProductNotFoundException e) {
            e.printStackTrace();
            throw  e;
		}
		return response;

   }

	
	
	
}
