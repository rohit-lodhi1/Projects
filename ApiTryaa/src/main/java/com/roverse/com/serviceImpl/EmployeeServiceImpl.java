package com.roverse.com.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.roverse.com.entity.Employee;
import com.roverse.com.service.IEmployeeReposetry;
import com.roverse.com.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	List<Employee> list;
	Employee empl;
	 Optional<Employee> omp;
	@Autowired
   IEmployeeReposetry emp; 
	   public EmployeeServiceImpl() {
		   list = new ArrayList<>();
		  }

		@Override
		public List<Employee> getEmployees() {
			Iterable<Employee> lst = emp.findAll();
			list.clear();
			lst.forEach(emp->{
				list.add(emp);
			});
			return list;
		}
		
		public Employee getEmployeeById(int id) {
			   //list=List.stream().filter(emp->(emp.getId()==id)).collect(Collectors.toList());
		    omp = emp.findById(id);
		   
		    if(omp.isPresent())
		    	return omp.get();
		
		 return null;   
		}

		@Override
		public Employee addEmployee(Employee ep) {
		//	return ac.addEmployee(emp);
			emp.save(ep);
			return ep;
		}
		
	   public int deleteEmployeeByID(int id) {
		    omp =emp.findById(id);
		    if(omp.isPresent()) {
		    	empl = omp.get();
		    	emp.delete(empl);
		    	empl=null;
		    	return id;
		    	
		    }	    
		 return 0;
	   }

	@Override
	public int updateEmployee(Employee emp1) {
		  omp=emp.findById(emp1.getId());
		
		    if(omp.isPresent()) {
		    	empl=omp.get();
		    	empl.setName(emp1.getName());
		    	empl.setEmail(emp1.getEmail());
		    }
		    emp.save(empl);
		    empl=null;
		return emp1.getId();
	     }

	@Override
	public List<Employee> getEmployeeSort(String order) {
		Iterable<Employee> sort = order.equals("ASC")?emp.findAll(Sort.by("name")):emp.findAll(Sort.by(Sort.Order.desc("name")));
        list.clear();
        sort.forEach(e->list.add(e));
		return list;
	}
	
	public List<Employee> getSearchResults(String field){
		try{
			int id=Integer.parseInt(field);
			list.clear();
			list.add(getEmployeeById(id));
			return list;
		}catch(Exception e) {
			if(field.contains("@gmail.com"))
				return emp.findByEmail(field);		
			return emp.findByName(field);
		}		
	}
	
	public List<Employee> getEmployeeStartsWith(String prefix){
		return emp.findByNameStartingWith(prefix);
	}

	@Override
	public Page<Employee> getEmployeeByPage(int page, int size) {
	   Pageable pemp =  PageRequest.of(page, size);
	    Page<Employee> list=emp.findAll(pemp);
		return list;
	}
	
}
