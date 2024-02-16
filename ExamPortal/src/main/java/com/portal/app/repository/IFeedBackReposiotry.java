package com.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.app.entity.Feedback;

public interface IFeedBackReposiotry extends JpaRepository<Feedback, Integer>{

}
