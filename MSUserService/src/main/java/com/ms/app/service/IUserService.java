package com.ms.app.service;

import java.util.List;

import com.ms.app.entites.User;

public interface IUserService {
    public List<User> addUser(User user);
    
    public User getUser(String id);
    
    public List<User> getAllUsers();
    
    public void deleteUser(String userId);
    
    
}
