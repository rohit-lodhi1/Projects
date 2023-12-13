package com.blog.app.service;

import java.security.Principal;
import java.util.List;

import com.blog.app.entity.Posts;

public interface IPostsService {
    public Posts addPost(Posts post,Principal principal);
    
    public Boolean deletePost(Long id);
    
    public List<Posts> getAllPosts();
    
    public Posts getPost(Long id);
    
    public Posts updatePost(Posts post);
}
