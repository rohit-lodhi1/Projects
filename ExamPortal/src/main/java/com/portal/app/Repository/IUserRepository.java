package com.portal.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.app.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	public User findByUserName(String userName);
    
}
