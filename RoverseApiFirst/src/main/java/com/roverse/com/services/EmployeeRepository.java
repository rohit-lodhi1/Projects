package com.roverse.com.services;

import org.springframework.data.repository.CrudRepository;

import com.roverse.entity.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
