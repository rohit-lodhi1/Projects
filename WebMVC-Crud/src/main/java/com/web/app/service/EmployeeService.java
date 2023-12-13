package com.web.app.service;

import java.util.List;

import com.web.app.entity.Employee;

public interface EmployeeService {
  public Employee save(Employee emp);
  public List<Employee> getAllEmployees();
  public Employee updateEmployee(Employee emp);
  public boolean deleteEmployee(Integer id);
  
  public Employee getEmployeeById(Integer id);
}
