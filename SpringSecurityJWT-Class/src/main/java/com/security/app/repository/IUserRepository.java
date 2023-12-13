package com.security.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.app.entity.User;

public interface IUserRepository  extends JpaRepository<User, Integer>{
    
	public Optional<User>  findByUserName(String username);
	
}
