package com.security.app.impl;

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

import com.security.app.entity.User;
import com.security.app.repository.IUserRepository;
import com.security.app.service.IUserService;

@Service
public class UserServiceImpl  implements IUserService,UserDetailsService{

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		user.setPassword(encoder.encode(user.getPassword()));
		return this.userRepo.save(user);
	}

	@Override
	public User findByUserName(String name) throws Exception {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepo.findByUserName(name);
		if(user.isPresent())
			return user.get();
		throw new Exception("User not found");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepo.findByUserName(username);
		if(user.isPresent()) {
			  User user1 = user.get();
			  List<GrantedAuthority>  authorities = user1.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
			  return new org.springframework.security.core.userdetails.User(username, user1.getPassword(), authorities);
		}
		throw new UsernameNotFoundException(username);
	}

}
