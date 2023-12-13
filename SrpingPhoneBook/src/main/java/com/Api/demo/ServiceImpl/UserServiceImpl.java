package com.Api.demo.ServiceImpl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Api.demo.Service.IUserService;
import com.Api.demo.entity.User;
import com.Api.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
     private UserRepo userRepo;
	
	@Override
	public Integer createUser(User user) {
		List<String> allEmails = userRepo.getAllEmails();
		
		for (String string : allEmails) {
			if(user.getUserEmail().equals(string))
			{
				return 0;
				
			}
		}
		 User save = userRepo.save(user);	
		 return save.getUserId();
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepo.findById(userId).get();
	}

	

	@Override
	public Page<User> getUserList(Integer pageNumber,Integer pageSize) {
		Pageable page=PageRequest.of(pageNumber, pageSize);
		 Page<User> findAll = userRepo.findAll(page);
		 return findAll;
	}

	@Override
	public User loginUser(String email, String password) {
		User user=userRepo.findByEmail(email);
		
		if(password.equals(user.getUserPassword()))
			return user;
		return null;
	}

	@Override
	public void deleteUserById(Integer userId) {
		userRepo.deleteById(userId);
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
