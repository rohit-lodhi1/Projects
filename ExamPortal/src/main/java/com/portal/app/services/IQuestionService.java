 package com.portal.app.services;

import java.util.List;
import java.util.Set;

import com.portal.app.entity.exam.Question;
import com.portal.app.entity.exam.Quiz;
import com.portal.app.entity.exam.Result;

public interface IQuestionService {
	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestions();

	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);

	public void deleteQuestion(Long questionId);
	
	
	public Object[] getResults(List<Question> questions)throws NullPointerException;
}
