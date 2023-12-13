package com.blog.app.controller;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
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

import com.blog.app.annotation.CurrentUser;
import com.blog.app.entity.Posts;
import com.blog.app.service.IPostsService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  
	@Autowired
	private IPostsService postService;
	
	
	// To Add Post 
	@PostMapping("")
	public ResponseEntity<Posts> addPost(@RequestBody Posts post,Principal principal){
		ResponseEntity<Posts> response = new ResponseEntity<Posts>(this.postService.addPost(post, principal),HttpStatus.CREATED);
		return response;
	}
	
	// To Get ALl Posts 
	@GetMapping("")
	public ResponseEntity<List<Posts>> getAllPosts(){
		ResponseEntity<List<Posts>>  response = new ResponseEntity<List<Posts>>(this.postService.getAllPosts(),HttpStatus.OK);
		return response;
	}
	
	// To Get Post By ID 
	@GetMapping("/{id}")
	public ResponseEntity<Posts> getPost(@PathVariable Long id,@CurrentUser UserPrincipal userPrincipal){
		System.out.println(userPrincipal.getName());
		ResponseEntity<Posts>  response = new ResponseEntity<Posts>(this.postService.getPost(id),HttpStatus.OK);
		return response;
	}
	
	// To Delete Post By ID 
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable Long id){
		ResponseEntity<String>  response = new ResponseEntity<String>(this.postService.deletePost(id)+"Post deleted id: "+id,HttpStatus.OK);
		return response;
	}
	
	// To Update Post 
	@PutMapping("")
	public ResponseEntity<Posts> updatePost(@RequestBody Posts post){
		ResponseEntity<Posts>  response = new ResponseEntity<Posts>(this.postService.updatePost(post),HttpStatus.OK);
		return response;
	}
	
}
