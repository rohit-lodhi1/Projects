package com.blog.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.entity.Roles;
import com.blog.app.entity.User;
import com.blog.app.entity.UserRoles;
import com.blog.app.repository.IUserRolesRepository;
import com.blog.app.service.IUserRolesService;

@Service
public class UserRolesServiceImpl implements IUserRolesService{

	@Autowired
	private IUserRolesRepository userRoleRepo;
	
	// delete User Role 
	@Override
	public boolean deleteUserRole(Long userId, Long roleId) {
		User user = new User();
		user.setId(userId);
		Roles role = new Roles();
		role.setId(roleId);
		UserRoles userRole = this.userRoleRepo.findByUserAndRole(user, role);
		this.userRoleRepo.delete(userRole);
		this.deleteOrphanalValues();
		return true;
	}

	@Override
	public void deleteOrphanalValues() {
		this.userRoleRepo.deleteOrphanalValues();
	}

}
