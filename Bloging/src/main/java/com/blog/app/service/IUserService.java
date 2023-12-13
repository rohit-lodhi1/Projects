package com.blog.app.service;

import java.security.Principal;
import java.util.List;

import com.blog.app.entity.Album;
import com.blog.app.entity.Posts;
import com.blog.app.entity.User;

public interface IUserService {
	
  public User findByUserName(String name);
	
   public User addUser(User user);
   
   public User getUserById(Long id);
   
   public User updateUser(User user);
   
   public List<User> getAllUsers();
   
   public Boolean deleteUser(Long id);
   
   public List<Posts> getPostsOfUser(String userName);
   
   public List<Album> getAlbumsOfUser(String userName);
   
   public Boolean checkUsernameAvailability(String userName);
   
   public Boolean checkEmailAvailability(String email);
   
   public boolean deleteUserByUserName(String userName, Principal principal);
   
   public boolean giveAdmin(String username);
   public boolean takeAdmin(String username);
}
