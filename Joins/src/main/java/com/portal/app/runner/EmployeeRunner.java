package com.portal.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.portal.app.Repo.IDepartmentRepository;
import com.portal.app.Repo.IEmployeeRepository;
import com.portal.app.entity.Department;
import com.portal.app.entity.Employee;


@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeRepository empRepo;
	@Autowired
	private IDepartmentRepository dRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
      List<Object[]> empNameDeptName = empRepo.getAllData();
      
      
      
      for(int i=0;i<empNameDeptName.size();i++) {
    	     Object[] objects = empNameDeptName.get(i);
    	     System.out.println((Employee)objects[0]+"  =>  ");
    	     System.out.println((Department)objects[1]);
      }
	}

}
