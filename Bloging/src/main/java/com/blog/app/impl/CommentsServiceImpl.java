package com.blog.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.Exceptions.CommentsNotFoundExceptions;
import com.blog.app.Exceptions.PostNotFoundException;
import com.blog.app.entity.Comments;
import com.blog.app.entity.Posts;
import com.blog.app.repository.ICommentsRepository;
import com.blog.app.service.ICommentsService;

@Service
public class CommentsServiceImpl implements ICommentsService {
	Posts post=null;
	
	@Autowired
	private ICommentsRepository commentRepo;
	
	// To Add Comments of A Post By Post ID
	@Override
	public Comments addComment(Comments comment) {
		return this.commentRepo.save(comment);
	}	
	
	// To Get Comments of A Post By Post ID
	@Override
	public List<Comments> getCommentsByPostId(Long id) {
	    if(id==0)
	    	throw new PostNotFoundException("Comments Not Found For Post Id : "+id);

		post = new Posts(); 		
	    post.setId(id);
        return this.commentRepo.findByPost(post);
	}

    // To get comment of post by post ID And comment ID 
	@Override
	public Comments getCommentById(Long cid, Long pid) {
		post = new Posts();
		post.setId(pid);
		Optional<Comments> comment = this.commentRepo.findByIdAndPost(cid, post);
		if(comment.isPresent())
			return comment.get();
		throw new CommentsNotFoundExceptions("comment not found for Post Id : "+pid+" And Comment Id : "+cid);
	}

    // To Update comment of post by post ID And comment ID 
	@Override
	public Comments updateCommentofPostById(Comments comment, Long pid,Long id) {
		post = new Posts();
		post.setId(pid);
	     Comments comment1 = this.commentRepo.findByIdAndPost(id, post).orElseThrow(()->new CommentsNotFoundExceptions("comment not found for Post Id : "+pid+" And Comment Id : "+id)); 
	    	  comment.setPost(post);
	    	  comment.setId(comment1.getId());
	    	  return this.commentRepo.save(comment);
	    
	}

    // To Delete comment of post by post ID And comment ID 
	@Override
	public Boolean deleteCommentByIdAndPost(Long postId, Long id) {
		post = new Posts();
		post.setId(postId);
	    Comments comment = this.commentRepo.findByIdAndPost(id, post).orElseThrow(()->new CommentsNotFoundExceptions("comment not found for Post Id : "+postId+" And Comment Id : "+id));
	        this.commentRepo.delete(comment);
	    	  return true;
	}




}
