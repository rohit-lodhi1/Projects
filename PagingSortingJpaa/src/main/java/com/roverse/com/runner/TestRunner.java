package com.roverse.com.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.roverse.com.entity.Employee;
import com.roverse.com.repositry.IEmployeeRepository;
//
//@Order(5)
//
/*
 * //@Component public class TestRunner implements CommandLineRunner {
 * 
 * @Autowired
 * 
 * IEmployeeRepository emp;
 * 
 * @Override public void run(String... args) throws Exception { //
 * emp.saveAll(Arrays.asList(new Employee(1,"ROhit","Rohitlodhi@gmail.com",200),
 * // new Employee(2,"Sumit","sumitlodhi@gmail.com",300), // new
 * Employee(3,"Abhinadan","abhinandanlodhi@gmail.com",400), // new
 * Employee(4,"vishal","vishallodhi@gmail.com",500), // new
 * Employee(5,"lakahan","lakhanlodhi@gmail.com",600), // new
 * Employee(6,"Dodar","dodarlodhi@gmail.com",700) // )); //
 * 
 * Iterable<Employee> findAll = emp.findAll(Sort.by("emp_sal"));
 * findAll.forEach(System.out::println);
 * 
 * }
 * 
 * }
 */