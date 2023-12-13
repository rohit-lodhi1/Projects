package com.web.app.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.app.Repository.RoleRepository;
import com.web.app.entity.Role;
import com.web.app.service.RoleService;

public class RoleServiceImpl implements RoleService {
	@Override
	public Role save(Role role) {
		
//		return this.roleRepo.save(role);
		return null;
	}

}
