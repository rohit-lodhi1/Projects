package com.roverse.com.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.roverse.com.entity.Models;
import com.roverse.com.entity.Product;
import com.roverse.com.entity.Products;
import com.roverse.com.repositry.IProductRpository;

@Component
public class ProductRunner implements CommandLineRunner {
   @Autowired
   private IProductRpository prd;
	
	
	@Override
	public void run(String... args) throws Exception {
		
//		Product pd = new Product();
//		pd.setPCode("BOX");
//		pd.setColors(Arrays.asList("red","black","blue","navy"));
//		
//	Set<String> set = new LinkedHashSet<>();
//	set.add("M1");
//	set.add("M2");
//	set.add("M3");
//		pd.setModels(set);
//		
//		Map<String ,String> map = new LinkedHashMap<>();
//		map.put("D1", "Small");
//		map.put("D2", "Medium");
//		map.put("D3", "Big");
//		pd.setDetails(map);
//	   
//		prd.save(pd);
//		//prd.findAll().forEach(System.out::println);
		
//		Products pd = new Products();
//		pd.setCode("123");
//	Models model = new Models();
//	model.setCode("987");
//	Models model2 = new Models();
//	model2.setCode("765");
//	
//	List<Models> models = new ArrayList<>();
//	models.add(model);
//	models.add(model2);
//	
//	pd.setModels(models);
//	prd.save(pd);
		this.prd.deleteById(1);
	  
		
		
       
	}

}
