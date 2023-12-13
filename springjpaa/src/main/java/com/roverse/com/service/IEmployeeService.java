package com.roverse.com.service;

import java.util.List;

import com.roverse.com.entity.Employee;



public interface IEmployeeService {
	 public List<Employee> getEmployees();
	   public Employee getEmployeeById(int id);
	   public Employee addEmployee(Employee emp);
	   public int deleteEmployeeByID(int id);
	   public int updateEmployee(Employee emp);
}
