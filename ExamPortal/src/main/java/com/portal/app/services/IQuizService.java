package com.portal.app.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.portal.app.entity.exam.Category;
import com.portal.app.entity.exam.Quiz;

public interface IQuizService {
	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuiz(Quiz quiz);

	public Set<Quiz> getQuizes();

	public Quiz getQuiz(Long quizId);

	public void deleteQuiz(Long quizId);

	public List<Quiz> getQuizesOfCategory(Category c);
	
	public List<Quiz> getActiveQuizes();
	
	public List<Quiz> getQuizByCategoryAndActive(Category c);
}
