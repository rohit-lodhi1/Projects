package com.roverse.com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.roverse.com.entity.Employee;



public interface IEmployeeService {
	 public List<Employee> getEmployees();
	   public Employee getEmployeeById(int id);
	   public Employee addEmployee(Employee emp);
	   public int deleteEmployeeByID(int id);
	   public int updateEmployee(Employee emp);
	   public List<Employee> getEmployeeSort(String order);
	   public List<Employee> getSearchResults(String field);
	   public List<Employee> getEmployeeStartsWith(String prefix);
	public Page<Employee> getEmployeeByPage(int page, int size);
}
