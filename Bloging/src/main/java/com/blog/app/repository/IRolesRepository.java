package com.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Roles;


public interface IRolesRepository extends JpaRepository<Roles, Long>    {

}
