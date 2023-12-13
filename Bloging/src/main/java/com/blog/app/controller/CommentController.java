package com.blog.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.entity.Comments;
import com.blog.app.entity.Posts;
import com.blog.app.service.ICommentsService;
import com.blog.app.service.IPostsService;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

	@Autowired
	private ICommentsService commentService;
	
	@Autowired
	private IPostsService postService;
	
	// To Get ALL Comments of Post By ID 
	@GetMapping("/{id}/comments")
	public ResponseEntity<List<Comments>> getAllCommentsByPostId(@PathVariable Long id){
		ResponseEntity<List<Comments>> response = new ResponseEntity<List<Comments>>(this.commentService.getCommentsByPostId(id),HttpStatus.OK);
		return response;
	}

	// To Get  Comment of Post By ID 
	@GetMapping("/{postId}/comments/{id}")
	public ResponseEntity<Comments> getCommentByPostId(@PathVariable Long postId,@PathVariable Long id){
		ResponseEntity<Comments> response = new ResponseEntity<Comments>(this.commentService.getCommentById(id, postId),HttpStatus.OK);
		return response;
	}
	
	// To Add Comment to Post By ID
	@PostMapping("/{postId}/comments")
	public ResponseEntity<Comments> addCommentToPost(@PathVariable Long postId,@RequestBody Comments comment){
		Posts post = new Posts();
		post.setId(postId);
		if(postId!=null || postId!=0)
		comment.setPost(post);
		ResponseEntity<Comments> response = new ResponseEntity<Comments>(this.commentService.addComment(comment),HttpStatus.CREATED);
		return response;
	}
	
	//To Update  Comment of Post By PostID And Comment Id 
	@PutMapping("/{postId}/comments/{id}")
	public ResponseEntity<Comments> updateCommentOfPost(@PathVariable Long postId,@PathVariable Long id, @RequestBody Comments comment){
		ResponseEntity<Comments> response = new ResponseEntity<Comments>(this.commentService.updateCommentofPostById(comment, postId,id),HttpStatus.OK);
		return response;
	}
	
	// To Delete  Comment of Post By PostID And Comment Id
	@DeleteMapping("/{postId}/comments/{id}")
	public ResponseEntity<String> deleteCommentByIdAndPost(@PathVariable Long postId,@PathVariable Long id){
		ResponseEntity<String> response = new ResponseEntity<String>(this.commentService.deleteCommentByIdAndPost(postId, id)+"Delete comment of Post ID : "+postId+" comment Id : "+id,HttpStatus.ACCEPTED);
		return response;
	}
	
}

