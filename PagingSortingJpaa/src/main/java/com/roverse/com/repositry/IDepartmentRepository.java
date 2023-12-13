package com.roverse.com.repositry;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roverse.com.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}
