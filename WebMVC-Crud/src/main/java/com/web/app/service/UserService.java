package com.web.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.app.entity.User;


public interface UserService {
  public User getUser(Integer id);
  public List<User> getUsers();
  
  public Map<Integer, String> getMappedRoles();
  
  public User saveUser(User user);
  
  public User updateUser(User user);
  
  public void deleteUser(Integer id);
  
  public void deleteRole(Integer id);
}
