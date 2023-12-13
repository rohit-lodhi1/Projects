package com.security.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.app.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}
