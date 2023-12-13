package com.web.app.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.web.app.Repository.IEmployeeRepository;
import com.web.app.bean.Employee;

public interface IEmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteEmployee(Integer id);
	
	public Employee getEmployeeById(Integer id);
	
	public Employee addEmployee(Employee emp);
	
	public Page<Employee> getEmpPage(Integer page) ;

}
