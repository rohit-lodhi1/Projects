package com.ms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.app.entites.User;

public interface IUserRepository extends JpaRepository<User, String>{

}
