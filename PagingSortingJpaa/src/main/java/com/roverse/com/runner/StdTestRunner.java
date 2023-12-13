package com.roverse.com.runner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.roverse.com.entity.Courses;
import com.roverse.com.entity.Student;
import com.roverse.com.repositry.ICoursesRepository;
import com.roverse.com.repositry.IEmployeeRepository;
import com.roverse.com.repositry.IStudentRepository;

//@Component
public class StdTestRunner implements CommandLineRunner {
	@Autowired
IStudentRepository iemp;
	
	
	@Autowired
	ICoursesRepository crepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		// TODO Auto-generated method stub
//		SimpleDateFormat date = new SimpleDateFormat("dd/mm/yy");
//		String s = date.format(new Date());
//	
//		
//		Student std = new Student();
//		12
//		2023-05-01 16:33:22.000000
//		kamal@!07
//		Kamal
//		std.setName("Kamal");
//		std.setFee(49094);
//	
		//std.setDOB(new Date());
	//	iemp.save(std);
	//	Example<Student> ex = Example.of(std); 
//		List<Student> findAll = iemp.findAll(ex);
//		findAll.forEach(System.out::println);
    //  System.out.println(iemp.findAll());
		
		
//		Student student = new Student();
//		student.setFee(100);
//		student.setEmail("rohitldohi@gmail.com");
//		student.setName("Rohit");
//		Courses course = new Courses();
//		course.setName("Rohit");
//		student.setCourses(Arrays.asList(course));
//		
//	iemp.save(student);
		
//		this.iemp.de//

	//crepo.save(course);
	}

}
