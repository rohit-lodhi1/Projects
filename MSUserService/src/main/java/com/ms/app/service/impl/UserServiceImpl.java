package com.ms.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.app.entites.Ratings;
import com.ms.app.entites.User;
import com.ms.app.exceptions.ResourceNotFoundException;
import com.ms.app.repository.IUserRepository;
import com.ms.app.service.IUserService;

@Service
public class UserServiceImpl  implements IUserService{

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	// creating user
	@Override
	public List<User> addUser(User user) {
		String randomUserID = UUID.randomUUID().toString();
		user.setId(randomUserID);
		List<User> list = new ArrayList<>();
		return this.userRepo.saveAll(list);
	}

	// getting user by id
	@Override
	public User getUser(String id) {
		User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found wit id "+id));
		ArrayList<Ratings> ratings = restTemplate.getForObject("http://localhost:8082/api/ratings/user/"+user.getId(),ArrayList.class );
		user.setRatings(ratings);
	    return user;
	}

	// getting all users
	@Override
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}

	// delete user by id
	@Override
	public void deleteUser(String userId) {
		 if(this.userRepo.existsById(userId))
			 this.userRepo.deleteById(userId);
	}

}
