package com.blog.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Comments;
import com.blog.app.entity.Posts;


public interface ICommentsRepository extends JpaRepository<Comments, Long>    {
   
	public List<Comments> findByPost(Posts post);
	
    public Optional<Comments> findByIdAndPost(Long id,Posts post);
}
