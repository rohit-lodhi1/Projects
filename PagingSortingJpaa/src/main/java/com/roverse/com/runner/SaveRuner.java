package com.roverse.com.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;

import com.roverse.com.entity.Employee;
import com.roverse.com.repositry.IEmployeeRepository;

//@Component
public class SaveRuner implements CommandLineRunner {
	@Autowired
	IEmployeeRepository imp;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Iterable<Employee> findAll = imp.findAll(Sort.by(Sort.Order.asc("name"),Sort.Order.desc("id")));
//		findAll.forEach(System.out::println);
//		
//		imp.findAll();
//
		
		Pageable page = PageRequest.of(2, 2);
		Page<Employee> empage = imp.findAll(page);
		empage.getContent().forEach(System.out::println);
		System.out.println(empage.isFirst());
		System.out.println(empage.isLast());
		System.out.println(empage.isEmpty());
		System.out.println(empage.hasNext());
		System.out.println(empage.getTotalPages());
		System.out.println(empage.getTotalElements());
		System.out.println(empage.getSize());
		 
	}

}
