package com.portal.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.portal.app.entity.Role;
import com.portal.app.entity.User;
import com.portal.app.entity.UserRole;
import com.portal.app.services.IUserServices;


@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner{

	@Autowired
	private IUserServices userServices;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * User user = new User(); user.setUserFirstName("Rohit");
		 * user.setUserLastName("Lodhi"); user.setUserName("rohit123");
		 * user.setProfileIMG("default.png");
		 * user.setUserPassword(this.bcryptPasswordEncoder.encode("987"));
		 * user.setUserEmail("rohitlodhi107@gmail.com");
		 * 
		 * Role role1 = new Role(); role1.setRoleId(1L); role1.setRoleName("ADMIN");
		 * 
		 * Set<UserRole> userRoleSet = new HashSet<>(); UserRole userRole = new
		 * UserRole(); userRole.setRole(role1); userRole.setUser(user);
		 * userRoleSet.add(userRole);
		 * 
		 * User user1 = userServices.createUser(user, userRoleSet);
		 * System.out.println(user1.getUserName());
		 */	
		
				
	}

}
