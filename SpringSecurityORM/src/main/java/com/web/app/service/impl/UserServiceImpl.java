package com.web.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.app.entities.User;
import com.web.app.repository.IUserRepository;
import com.web.app.service.IUserService;

@Service
public class UserServiceImpl  implements IUserService,UserDetailsService{
 
	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(encoder.encode(user.getPassword()));
	 return this.userRepo.save(user);
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepo.findById(id);
		if(user.isPresent())
			return user.get();
		throw new RuntimeException("User Not Found id : "+id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	    Optional<User> user = this.userRepo.findByUserName(username);
	    if(user.isPresent())
	    {
	    	 User user1 = user.get();
	    	 List<GrantedAuthority> authorities = user1.getUserRoles()
	    			 .stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	    	 return new org.springframework.security.core.userdetails.User(username, user1.getPassword(),  authorities);
	    }
	    else
	    	throw new UsernameNotFoundException("User Not Found with User Name : "+username);
	
	}
	
	
}
