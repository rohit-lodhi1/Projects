package com.portal.app.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.app.Repository.IResultRepository;
import com.portal.app.entity.User;
import com.portal.app.entity.exam.Ranks;
import com.portal.app.entity.exam.Result;
import com.portal.app.services.IResultService;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultControlle {
   
	@Autowired
	private IResultService resultService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Result> getResult(@PathVariable Integer id) {
		return new ResponseEntity<Result>(this.resultService.getResult(id),HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Result>> getResultOfUser(@PathVariable Long id){
		return new ResponseEntity<List<Result>>(this.resultService.getResultByUid(id),HttpStatus.OK);
	}
	
	@GetMapping("/user/us/{qid}")
	public ResponseEntity<List<User>> getResultsByPage(@PathVariable Long qid){
		return new ResponseEntity<List<User>>(this.resultService.getUserByResult(qid),HttpStatus.OK);
	}
	
	@GetMapping("/ranks")
	public ResponseEntity<Ranks> getRanks(){
		ResponseEntity<Ranks> response = new ResponseEntity<Ranks>(this.resultService.getRanks(),HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/ranks/{qid}")
	public ResponseEntity<Ranks> getRanksByQuiz(@PathVariable Long qid){
		ResponseEntity<Ranks> response = new ResponseEntity<Ranks>(this.resultService.getRanksByQuiz(qid),HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteResult(@PathVariable Integer id){
	  return new ResponseEntity<Boolean>(this.resultService.deleteResultById(id),HttpStatus.ACCEPTED);	
	}
}
