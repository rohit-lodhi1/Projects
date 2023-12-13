package com.blog.app.impl;

import java.security.Principal;
import java.sql.SQLDataException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.app.Exceptions.UserFoundException;
import com.blog.app.Exceptions.UserNotFoundException;
import com.blog.app.entity.Album;
import com.blog.app.entity.Posts;
import com.blog.app.entity.RoleName;
import com.blog.app.entity.Roles;
import com.blog.app.entity.User;
import com.blog.app.entity.UserRoles;
import com.blog.app.repository.IUserRepository;
import com.blog.app.service.IUserRolesService;
import com.blog.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private IUserRolesService userRoleService;

	//  To Add User
	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return this.userRepo.save(user);
	}


	//  To Get User By ID 
	@Override
	public User getUserById(Long id) {
		User user = this.userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found with id: " + id));
		
		return user;
	}

	// To Update User 
	@Override
	public User updateUser(User user) {
		try {
			if (this.userRepo.existsById(user.getId()))
				return this.userRepo.save(user);
		} catch (DataAccessException e) {throw new UserFoundException("User Name ALready exits: ");}
		throw new UserNotFoundException("User Not Found with id: " + user.getId());
	}

	// To Get ALl users 
	@Override
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}

	// To Delete user By ID 
	@Override
	public Boolean deleteUser(Long id) {
		if (this.userRepo.existsById(id)) {
			this.userRepo.deleteById(id);
			return true;
		}
		throw new UserNotFoundException("User not Found With ID : " + id);
	}

	// To Get Posts created by User By UserName
	@Override
	public List<Posts> getPostsOfUser(String userName) {
		User user = this.userRepo.findByUserName(userName).orElseThrow(()->new UserNotFoundException("User not found with userName : " + userName));
		return user.getPosts();
	}

	// To Get ALbums created by User By UserName
	@Override
	public List<Album> getAlbumsOfUser(String userName) {
		User user = this.userRepo.findByUserName(userName).orElseThrow(()->new UserNotFoundException("User not found with userName : " + userName));
        return user.getAlbums();	
	}

	// To Check userName is Available or Not
	@Override
	public Boolean checkUsernameAvailability(String userName) {
		return !this.userRepo.existsByUserName(userName);
	}

	// To Check Email is Available or Not
	@Override
	public Boolean checkEmailAvailability(String email) {
		return !this.userRepo.existsByEmail(email);
	}

	@Override
	public boolean deleteUserByUserName(String userName, Principal principal) {
		 User loggedIn = this.userRepo.findByUserName(principal.getName()).orElseThrow(()->new UserNotFoundException("User Are not valid not found with userName : " + principal.getName()));
			User user = this.userRepo.findByUserName(userName).orElseThrow(()->new UserNotFoundException("User not found with userName : " + userName));
			if (isAdmin(loggedIn) && !isAdmin(user)) {
				this.userRepo.delete(user);
				return true;
			}
		throw new UserNotFoundException("User are Not authorized   : " + userName);
	}

	// Give admin role to User
	public boolean giveAdmin(String userName) {
		  User user = this.userRepo.findByUserName(userName).orElseThrow(()->new UserNotFoundException("User not found with userName : " + userName));
			if (isAdmin(user))
				return false;
			UserRoles userRole = new UserRoles();
			userRole.setRole(new Roles(1L, RoleName.ADMIN.toString()));
			userRole.setUser(user);
			user.getUserRoles().add(userRole);
			this.userRepo.save(user);
			return true;
	}

	// take admin from user by username
	@Override
	public boolean takeAdmin(String userName) {
		User user = this.userRepo.findByUserName(userName).orElseThrow(()->new UserNotFoundException("User not found with userName : " + userName));
			Set<UserRoles> userRoles = new HashSet<>();
			UserRoles userRole = new UserRoles();
			userRole.setRole(new Roles(2L, RoleName.USER.toString()));
			userRoles.add(userRole);
			user.setUserRoles(userRoles);
			this.userRepo.save(user);
			this.userRoleService.deleteUserRole(user.getId(), 1L);
			return true;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findByUserName(username).orElseThrow(()->new UserNotFoundException("Username not found " + username));
			Set<UserRoles> userRoles = user.getUserRoles();
			List<GrantedAuthority> authorities = userRoles.stream()
					.map(role -> new SimpleGrantedAuthority(role.getRole().getRolename())).collect(Collectors.toList());
			return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}	

	public Boolean isAdmin(User user) {
		boolean isAdmin = user.getUserRoles().stream().anyMatch(new Predicate<UserRoles>() {	
			@Override
			public boolean test(UserRoles t) {
				return t.getRole().getRolename().equals(RoleName.ADMIN.toString())?true:false;
			}
		});
		return isAdmin;
	}

	@Override
	public User findByUserName(String name) {
		 User user = this.userRepo.findByUserName(name).orElseThrow(()-> new  UserNotFoundException("user Not FOund : "+name));
		 return user;
	}

}
