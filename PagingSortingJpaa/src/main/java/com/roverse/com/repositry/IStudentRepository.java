package com.roverse.com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roverse.com.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
