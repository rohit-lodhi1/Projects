package com.roverse.com.Test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.roverse.com.Reposetary.IStudentReposetry;
import com.roverse.com.entity.Student;

@Component
public class Test implements CommandLineRunner{
@Autowired
	private IStudentReposetry st;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(st.getClass().getName());
		Student std = new Student();
		std.setEmail("rohitlodhi107@gmail.com");
		std.setName("Rohit Lodhi");
		//st.save(std);
		Optional<Student> findById = st.findById(1);
      System.out.println(findById.isPresent());

	}

}
