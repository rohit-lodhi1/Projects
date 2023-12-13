package com.portal.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.app.entity.Department;

public interface IDepartmentRepository  extends JpaRepository<Department, Integer>{

}
