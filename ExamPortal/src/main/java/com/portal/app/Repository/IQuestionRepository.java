package com.portal.app.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.app.entity.exam.Question;
import com.portal.app.entity.exam.Quiz;

public interface IQuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
