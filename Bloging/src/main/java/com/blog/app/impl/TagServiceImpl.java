package com.blog.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.Exceptions.TagNotFoundException;
import com.blog.app.entity.Tag;
import com.blog.app.repository.ITagRepository;
import com.blog.app.service.ITagService;

@Service
public class TagServiceImpl implements ITagService{

	@Autowired
	private ITagRepository tagRepo;
	
	// add tag 
	@Override
	public Tag addTag(Tag tag) {
		return this.tagRepo.save(tag);
	}

	// updating tag
	@Override
	public Tag updateTag(Tag tag) {
		if(this.tagRepo.existsById(tag.getId()))
			return this.tagRepo.save(tag);
		throw new TagNotFoundException("Tag Not Found with id : "+tag.getId());
	}

}
