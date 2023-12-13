package com.portal.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.portal.app.Repo.IStudentRepository;
import com.portal.app.entity.Address;
import com.portal.app.entity.Student;

//@Component
public class StudentRunner implements CommandLineRunner {
	
    @Autowired
	private IStudentRepository stdRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
//	   int ch=65;
//	  String [] city= {"Bhopal","Indore","Dewas","Gwalior","Ujjain"};
//	  String [] names = {"Sumit","Lakhan","Abhilandan","Mayank","rohan"};
//	   int n=0,j=0;
//		for(int i=0;i<20;i++) {
//			if(n==names.length) {
//				n=0;
//			}
//			if(j==city.length)
//				j=0;
//			
//			 Student st = new Student();
//			 st.setSName(names[n++]);
//			 Address address = new Address(city[j++],"M.p");
//			 st.setAddress(address);
//			stdRepo.save(st);
//			ch++;
//		
//		}
	//   List<Student> studentByCity = stdRepo.getAllStudentAndAddress();
	 //  studentByCity.forEach(System.out::println);
	}

}
