package com.standards.app.service;

import java.util.List;

import com.standards.app.entites.dto.UserDto;

public interface IUserService {

	public UserDto createUser(UserDto userDto);
	
	public UserDto getUser(Integer id);
	
	public List<UserDto> getAllUsers();
	
	public boolean deleteUser(Integer id);
	
	public UserDto updateUser(UserDto userDto,Integer id);
}
