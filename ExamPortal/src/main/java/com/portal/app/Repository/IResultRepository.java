package com.portal.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portal.app.entity.User;
import com.portal.app.entity.exam.Quiz;
import com.portal.app.entity.exam.Result;

public interface IResultRepository extends JpaRepository<Result, Integer> {
   
	public List<Result> findByUser(User user);
	
	@Query("Select distinct(user) from  Result r where r.quiz.qId=:qid")
	public List<User> getUserFromResult(Long qid);
	
	public List<Result> findByUserOrderByGenerateDate(User user);
	
	public List<Result> findByUserAndQuizOrderByGenerateDate(User user,Quiz quiz);
}
