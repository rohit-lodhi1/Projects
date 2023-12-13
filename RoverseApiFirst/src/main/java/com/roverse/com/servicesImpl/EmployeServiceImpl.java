package com.roverse.com.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roverse.com.ApiFirstApplication;
import com.roverse.com.controller.MyController;
import com.roverse.com.services.IEmployeService;
import com.roverse.entity.Employee;

@Service
public class EmployeServiceImpl implements IEmployeService{
List<Employee> list;

   public EmployeServiceImpl() {
	   list = new ArrayList<Employee>();
	   list.add(new Employee(1,"Rohit,","rohitlodhi123@gmail.com"));
	   list.add(new Employee(2,"Sumit,","rohitlodhi124@gmail.com"));
	   list.add(new Employee(3,"Lakhan,","saritalodhi123@gmail.com"));
	   int a = 0X10;
   }

	@Override
	public List<Employee> getEmployees() {
		return list;
	}
	
	public Employee getEmployeeById(int id) {
		   //list=List.stream().filter(emp->(emp.getId()==id)).collect(Collectors.toList());
		Employee emp=null;
		for(Employee em:list) {
			if(em.getId()==id)
			{
				emp=em;
				break;
			}
		}
	
	 return emp;   
	}

	@Override
	public Employee addEmployee(Employee emp) {
	//	return ac.addEmployee(emp);
		return list.add(emp)?emp:null;
	}
	
   public int deleteEmployeeByID(int id) {
	 list.forEach(e->{
		 if(e.getId()==id)
		 {
			   list.remove(e);
		 }
	 });
	 return id;
	
   }

@Override
public int updateEmployee(Employee emp1) {
	   for(Employee emp:list) {
		   if(emp.getId()==emp1.getId())
		   {
			  emp.setName(emp1.getName());
			  emp.setEmail(emp1.getEmail());
			   return emp.getId();
		   }
	   }
	   return 0;
	
     }
}
