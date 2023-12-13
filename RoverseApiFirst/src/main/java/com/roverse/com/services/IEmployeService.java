package com.roverse.com.services;

import java.util.List;

import com.roverse.entity.Employee;

public interface IEmployeService {
   public List<Employee> getEmployees();
   public Employee getEmployeeById(int id);
   public Employee addEmployee(Employee emp);
   public int deleteEmployeeByID(int id);
   public int updateEmployee(Employee emp);
}
