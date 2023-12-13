package com.web.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
