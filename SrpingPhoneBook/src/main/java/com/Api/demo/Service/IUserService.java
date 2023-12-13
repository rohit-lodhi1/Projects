package com.Api.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Api.demo.entity.User;

public interface IUserService {
	public Integer createUser(User user);
	public User getUserById(Integer userId);
	public void deleteUserById(Integer userId);
	public void updateUser(User user);
	public Page<User> getUserList(Integer pageNumber,Integer pageSize);
	public User loginUser(String email,String password);

}
