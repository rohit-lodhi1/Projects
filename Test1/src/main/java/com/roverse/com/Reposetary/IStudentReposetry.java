package com.roverse.com.Reposetary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.roverse.com.entity.Student;

public interface IStudentReposetry extends PagingAndSortingRepository<Student, Integer> {

}
