package com.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Photos;


public interface IPhotosRepository extends JpaRepository<Photos, Long>    {

}
