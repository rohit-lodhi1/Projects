package com.blog.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.blog.app.entity.Roles;
import com.blog.app.entity.User;
import com.blog.app.entity.UserRoles;

public interface IUserRolesRepository extends JpaRepository<UserRoles, Long> {
    
	public UserRoles findByUserAndRole(User user,Roles role);
	
	@Modifying
	@Transactional
	@Query("Delete from UserRoles ur where ur.user is NULL")
	public void deleteOrphanalValues();
}
