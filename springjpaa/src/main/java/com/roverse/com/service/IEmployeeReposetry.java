package com.roverse.com.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.roverse.com.entity.Employee;


public interface IEmployeeReposetry extends CrudRepository<Employee, Integer>{

}
