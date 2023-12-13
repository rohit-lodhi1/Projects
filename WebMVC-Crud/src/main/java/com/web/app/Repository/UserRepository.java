package com.web.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.app.entity.Student;
import com.web.app.entity.User;

/*
import org.springframework.data.jpa.repository.JpaRepository;

import com.web.app.entity.User;
*/
public interface UserRepository extends JpaRepository<Student, Integer>{

}
