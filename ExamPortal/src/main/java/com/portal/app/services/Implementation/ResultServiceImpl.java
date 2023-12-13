package com.portal.app.services.Implementation;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.app.Repository.IResultRepository;
import com.portal.app.entity.User;
import com.portal.app.entity.exam.Quiz;
import com.portal.app.entity.exam.Ranks;
import com.portal.app.entity.exam.Result;
import com.portal.app.services.IResultService;
import com.portal.app.services.IUserServices;

@Service
public class ResultServiceImpl implements IResultService{
  @Autowired
  private IResultRepository resultRepo;
  
  @Autowired 
  private IUserServices userService;
  
	@Override
	public Result save(Result result) {
		return this.resultRepo.save(result);
	}

	@Override
	public Result getResult(Integer id) {
		return this.resultRepo.findById(id).get();
	}

	@Override
	public List<Result> getAllResult() {
		return this.resultRepo.findAll();
	}

	@Override
	public List<Result> getResultByUid(Long id) {
		User user = new User();
		user.setUserId(id);
		return this.resultRepo.findByUser(user);
	}

	@Override
	public Page<Result> getResultByPage(Integer pageNo, Integer pageSize) {
	  Pageable page= PageRequest.of(pageNo, pageSize);
	    Page<Result> resultPage = this.resultRepo.findAll(page);
		return resultPage;
	}
	
	@Override
	public List<User> getUserByResult(Long qid) {
			return this.resultRepo.getUserFromResult(qid);
		}

	@Override
	public Ranks getRanks() {
		List<User> users = this.userService.getAllUsers();
		Set<Result> result = new HashSet<>();
		for(User user:users) {
			
			List<Result> results = this.resultRepo.findByUserOrderByGenerateDate(user);
			if(results.size()>0)
			result.add(results.get(results.size()-1));
		}
	return new Ranks(result);
	}

	@Override
	public Boolean deleteResultById(Integer id) {
	    if(this.resultRepo.existsById(id)) {
	    	this.resultRepo.deleteById(id);
	    	return true;
	    }
		return false;
	}

	@Override
	public Ranks getRanksByQuiz(Long id) {
		List<User> users = this.userService.getAllUsers();
		Set<Result> result = new HashSet<>();
		Quiz quiz = new Quiz();
		quiz.setQId(id);
		for(User user:users) {
			
			List<Result> results = this.resultRepo.findByUserAndQuizOrderByGenerateDate(user,quiz);
			if(results.size()>0)
			result.add(results.get(results.size()-1));
		}
	return new Ranks(result);
	
		
	}
		
		
	

}
