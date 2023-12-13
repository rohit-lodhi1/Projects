package com.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Address;


public interface IAddressRepository extends JpaRepository<Address, Long>   {

}
