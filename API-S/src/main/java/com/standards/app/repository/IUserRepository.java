package com.standards.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.standards.app.entites.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

}
