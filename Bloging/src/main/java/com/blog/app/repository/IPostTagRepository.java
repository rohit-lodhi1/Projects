package com.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.PostTag;


public interface IPostTagRepository  extends JpaRepository<PostTag, Long>   {

}
