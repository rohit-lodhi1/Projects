package com.standards.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.standards.app.entites.User;
import com.standards.app.entites.dto.UserDto;
import com.standards.app.exception.ResourceNotFoundException;
import com.standards.app.repository.IUserRepository;
import com.standards.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper; 
	
	// creating user
	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.userDtoToUser(userDto);
		return this.userToUserDto(this.userRepo.save(user));
	}

	// getting user by id 
	@Override
	public UserDto getUser(Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
		return this.userToUserDto(user);
	}

	// getting all Users
	@Override
	public List<UserDto> getAllUsers() {
         List<User> user = this.userRepo.findAll();
        return user.stream().map(user1 -> userToUserDto(user1)).collect(Collectors.toList());
	}

	//  deleting user by id
	@Override
	public boolean deleteUser(Integer id) {
		if(this.userRepo.existsById(id)){
			this.userRepo.deleteById(id);
			return true;
		}
		throw new ResourceNotFoundException("User ","id",id);
	}

	// updating user
	@Override
	public UserDto updateUser(UserDto userDto,Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User ","id",id));
		
		user.setUserName(userDto.getUserName());
		user.setEmail(userDto.getEmail());
		user.setMobileNo(userDto.getMobileNo());
		
		return this.userToUserDto(this.userRepo.save(user));
	}
	
	private UserDto userToUserDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}
	
	private User userDtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto, User.class);
	}
	
}
