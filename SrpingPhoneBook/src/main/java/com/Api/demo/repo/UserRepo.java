package com.Api.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Api.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.userEmail=:e")
	User findByEmail(@Param("e") String email);
	
	@Query("select u.userEmail from User u")
	List<String> getAllEmails();

}
