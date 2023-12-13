package com.web.app.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.Repository.RoleRepository;
import com.web.app.Repository.UserRepository;
import com.web.app.entity.User;
import com.web.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
@Autowired
	private UserRepository userRepo;

@Autowired
private RoleRepository roleRepo;
	
	@Override
	public User getUser(Integer id) {
		
		return this.userRepo.findById(id).get();
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return this.userRepo.findAll();
	}

	@Override
	public Map<Integer, String> getMappedRoles() {
		// TODO Auto-generated method stub
		List<User> list = this.userRepo.findAll();
		   Map<Integer, String> map = new  HashMap<>();
		   list.forEach(l->{
			   map.put(l.getUId(), l.getRole().getRole());
		   });
		return map;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepo.save(user);
	}

	

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		this.userRepo.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		if(this.userRepo.existsById(user.getUId())) {
			this.userRepo.save(user);
			return this.userRepo.findById(user.getUId()).get();
		}
		return user;
	}
	
	public void deleteRole(Integer id) {
		this.roleRepo.deleteById(id);
	}

	/*
	 * @Autowired private UserRepository userRepo;
	 * 
	 * @Override public User createUser(User user) { // TODO Auto-generated method
	 * stub return this.userRepo.save(user); }
	 * 
	 * @Override public User updateUser(User user) { // TODO Auto-generated method
	 * stub return this.userRepo.save(user); }
	 * 
	 * @Override public boolean deleteUser(Integer id) { // TODO Auto-generated
	 * method stub try{this.userRepo.deleteById(id);}catch(Exception e) {} return
	 * true; }
	 * 
	 * @Override public List<User> getUsers() { // TODO Auto-generated method stub
	 * return this.userRepo.findAll(); }
	 * 
	 * @Override public User getUserByID(Integer id) { Optional<User> user =
	 * this.userRepo.findById(id); if(user.isPresent()) return user.get(); return
	 * null; }
	 * 
	 */}
