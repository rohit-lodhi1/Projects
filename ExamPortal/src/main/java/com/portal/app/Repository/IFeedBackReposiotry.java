package com.portal.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.app.entity.Feedback;

public interface IFeedBackReposiotry extends JpaRepository<Feedback, Integer>{

}
