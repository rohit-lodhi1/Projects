package com.portal.app.services;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.portal.app.entity.User;
import com.portal.app.entity.UserRole;
import com.portal.app.entity.payload.UserPayLoad;


public interface IUserServices {
	//create user
   public User createUser(User user,Set<UserRole> userRoles) throws Exception;
   
   //get user
   public User getUser(String userName);
   
   // delete user by Id
   public Long deleteUser(Long userID);

public User updateUser(UserPayLoad user);

public List<User> getAllUsers();
public Page<User> getAllUsers(int pageNo,int pageSize);

public User getUserById(Long id);


}
