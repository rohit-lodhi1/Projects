package com.security.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.app.Repo.UserRepository;
import com.security.app.entity.User;
import com.security.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        // Implement the logic to save the user in the database
        return userRepository.save(user);
    }
}