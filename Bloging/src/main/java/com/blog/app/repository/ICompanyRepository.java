package com.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Company;


public interface ICompanyRepository extends JpaRepository<Company, Long>    {

}
