package com.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Geo;


public interface IGeoRepository extends JpaRepository<Geo, Long>    {

}
