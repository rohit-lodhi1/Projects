package com.web.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.app.bean.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
