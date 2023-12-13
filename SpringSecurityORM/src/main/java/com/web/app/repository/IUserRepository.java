package com.web.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.app.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
   public Optional<User> findByEmail(String email);
   
   public Optional<User> findByUserName(String userName);
}
