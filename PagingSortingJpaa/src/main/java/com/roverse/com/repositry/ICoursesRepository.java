package com.roverse.com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roverse.com.entity.Courses;

public interface ICoursesRepository extends JpaRepository<Courses, Integer> {

}
