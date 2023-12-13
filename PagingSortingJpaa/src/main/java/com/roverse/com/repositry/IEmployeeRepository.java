package com.roverse.com.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.roverse.com.entity.Employee;
import com.roverse.com.entity.Student;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
