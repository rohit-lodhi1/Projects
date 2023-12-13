package com.roverse.com.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.roverse.com.entity.Employee;

public interface IEmployeeReposetry extends PagingAndSortingRepository<Employee, Integer>{
   public List<Employee> findByName(String name);
   public List<Employee> findByEmail(String email);
   public List<Employee> findByNameStartingWith(String prefix);
}
