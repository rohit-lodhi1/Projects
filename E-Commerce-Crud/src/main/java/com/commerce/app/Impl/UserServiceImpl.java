package com.commerce.app.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.IUserRepositoty;
import com.commerce.app.Service.IUserService;
import com.commerce.app.entities.User;
import com.commerce.app.exception.UserFoundException;
import com.commerce.app.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Autowired
	private IUserRepositoty userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findByUsernameAndPassword(username,password);
		if(user!=null) {
			return user;
		}else
			throw new UserNotFoundException("Invalid credentails");
		
		
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		if(this.userRepo.findByUsername(user.getUsername()).isEmpty())
		{
		    user.setPassword(encoder.encode(user.getPassword()));
		   return this.userRepo.save(user);
		}
		else
			throw new UserFoundException("User name already exists");
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		
		if(this.userRepo.existsById(user.getUid())) {
		return 	this.userRepo.save(user);
		}
		throw new UserNotFoundException("User Id Must not be null ");
		
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
		this.userRepo.deleteById(id);
		return true;
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepo.findById(id);
		if(user.isPresent())
			return user.get();
		throw new UserNotFoundException("User not Found with "+id);
		
	}

	@Override
	public List<User> getUsers() {
		
		return this.userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<User> user = this.userRepo.findByUsername(username);
		 if(user.isPresent()) {
			 User user1 = user.get();
			 List<GrantedAuthority> authority = user1.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
			 return new org.springframework.security.core.userdetails.User(username, user1.getPassword(), authority);
		 }
		 
		return null;
	}

}
