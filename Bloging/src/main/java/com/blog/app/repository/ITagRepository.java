package com.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Tag;


public interface ITagRepository extends JpaRepository<Tag, Long>    {

}
