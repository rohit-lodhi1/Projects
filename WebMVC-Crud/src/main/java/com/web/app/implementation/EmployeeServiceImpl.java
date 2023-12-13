package com.web.app.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.Repository.EmployeeRepository;
import com.web.app.entity.Employee;
import com.web.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return this.empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.empRepo.findAll();
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		if(this.empRepo.existsById(emp.getEId())) {
			this.empRepo.save(emp);
		}
		
		return emp;
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		 this.empRepo.deleteById(id);
		 return true;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return this.empRepo.findById(id).get();
	}

}
