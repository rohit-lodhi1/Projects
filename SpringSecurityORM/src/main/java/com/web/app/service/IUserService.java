package com.web.app.service;

import java.util.Optional;

import com.web.app.entities.User;

public interface IUserService {

	public User addUser(User user);
	
	public User getUserById(Integer id);
}
