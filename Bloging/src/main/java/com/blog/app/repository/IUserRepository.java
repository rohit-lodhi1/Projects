package com.blog.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Album;
import com.blog.app.entity.Posts;
import com.blog.app.entity.User;


public interface IUserRepository extends JpaRepository<User, Long>  {
  
	public Optional<User> findByUserNameAndPassword(String userName,String password);
	
	public Optional<User> findByUserName(String userName);
	
	public Optional<User> findByEmail(String email);
	
    public Boolean existsByUserName(String userName);
    
    public Boolean existsByEmail(String email);
    
}
