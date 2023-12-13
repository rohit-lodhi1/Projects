package com.web.app.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.web.app.Repository.IEmployeeRepository;
import com.web.app.Service.IEmployeeService;
import com.web.app.bean.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.empRepo.findAll();
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		try {
		 this.empRepo.deleteById(id);
		 return true;
		}catch(Exception e) {
			e.printStackTrace();
          return false;			
		}
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return this.empRepo.findById(id).get();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return this.empRepo.save(emp);
	} 
	
	public Page<Employee> getEmpPage(Integer page) {
		Pageable pageEmp =  PageRequest.of(page, 5);
		Page<Employee> empPage = this.empRepo.findAll(pageEmp);
		return empPage;
	}
   
}
