package com.portal.app.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.app.Repository.IResultRepository;
import com.portal.app.entity.User;
import com.portal.app.entity.exam.Question;
import com.portal.app.entity.exam.Quiz;
import com.portal.app.entity.exam.Result;
import com.portal.app.services.IQuestionService;
import com.portal.app.services.IQuizService;
import com.portal.app.services.IResultService;
import com.portal.app.services.IUserServices;


@RestController
@RequestMapping("/questions")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private IQuestionService questionService;
	@Autowired
	private IQuizService quizService;
	
	@Autowired
	private IUserServices userSerivce;
	
	@Autowired
	private IResultService resultService;
	
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
	
		return ResponseEntity.ok(this.questionService.addQuestion(question));
		
	}
	
	//update question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
		
	}
	
	// get all questions of any quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizId") Long quizId){
//		Quiz quiz = new Quiz();
//		quiz.setQId(quizId);
//		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//		return ResponseEntity.ok(questionsOfQuiz);
		
		Quiz quiz = this.quizService.getQuiz(quizId);
		Set<Question> questions = quiz.getQuestions();
		List<Question> list = new ArrayList(questions);
		
		if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) 	
			list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
	
		list.forEach(q->q.setAnswer(""));
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/quiz/all/{quizId}")
	public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("quizId") Long quizId){

		Quiz quiz = new Quiz();
		quiz.setQId(quizId);
		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
	
		return ResponseEntity.ok(questionsOfQuiz);
	}

	
	
	
	//get single questions
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId) {
		
		return this.questionService.getQuestion(quesId);
		
	}
	
	
	
	
	//delete single Question
	@DeleteMapping("/{quesId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable("quesId") Long quesId) {
		
		this.questionService.deleteQuestion(quesId);
		return ResponseEntity.ok("Question Deleted questionID: "+quesId);
	}
	
	
	@PostMapping("/result/{id}")
	public ResponseEntity<?> getResult(@PathVariable("id") Long id,@RequestBody List<Question> questions){
		
		if(questions.size()>0)
		{
			Object[] a =this.questionService.getResults(questions);
			
	     Result result =(Result)a[0]; 
	     Quiz quiz = new Quiz();
	     quiz.setQId(questions.get(0).getQuiz().getQId());
	     User user = new User();
	     user.setUserId(this.userSerivce.getUserById(id).getUserId());
	     result.setQuiz(quiz);
	     result.setUser(user);
	     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	     Date date = new Date();
	     result.setGenerateDate(date);
	     a[0]=this.resultService.save(result);
	     
		return ResponseEntity.ok(a);
		}
		
		return ResponseEntity.ok("No result");
		
	}
	
	
	
	
}
