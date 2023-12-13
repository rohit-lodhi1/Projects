package com.security.app.service;

import java.util.Optional;

import com.security.app.entity.User;

public interface IUserService {

	public User add(User user);
	
	public User findByUserName(String name) throws Exception;
	
	
}
