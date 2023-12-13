package com.blog.app.impl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.Exceptions.PostNotFoundException;
import com.blog.app.entity.PostTag;
import com.blog.app.entity.Posts;
import com.blog.app.entity.Tag;
import com.blog.app.entity.User;
import com.blog.app.repository.IPostsRepository;
import com.blog.app.service.IPostsService;
import com.blog.app.service.ITagService;
import com.blog.app.service.IUserService;

@Service
public class PostsServiceImpl implements IPostsService{

	@Autowired
	private IPostsRepository postRepo;
	
	@Autowired
	private ITagService tagService;
	
	@Autowired
	private IUserService userService;
	
	
	// To Add Post 
	@Override
	public Posts addPost(Posts post,Principal principal) {
		User user = this.userService.findByUserName(principal.getName());
		post.setUser(user);

		List<PostTag> postTags = post.getPostTags();
		
		for(PostTag postTag:postTags) {
			Tag tag = postTag.getTag();
		    postTag.setTag(	this.tagService.addTag(tag));
		}
		
		return this.postRepo.save(post);
	}

	// To Delete Post By ID
	@Override
	public Boolean deletePost(Long id) {
		if(this.postRepo.existsById(id)){
			this.postRepo.deleteById(id);
			return true;
		}
		throw new PostNotFoundException("Post not found with id : "+id);
	}
    
	// Get All Posts
	@Override
	public List<Posts> getAllPosts() {
		return this.postRepo.findAll();
	}

	// To Get Post By ID 
	@Override
	public Posts getPost(Long id) {
		Posts post = this.postRepo.findById(id).orElseThrow(()->new PostNotFoundException("Post not Found with id :"+id));
			return post;
	}

	// To Update Post
	@Override
	public Posts updatePost(Posts post) {
		if (this.postRepo.existsById(post.getId()))
			return this.postRepo.save(post);
		throw new PostNotFoundException("Post not update with id: " + post.getId());
	}

}
