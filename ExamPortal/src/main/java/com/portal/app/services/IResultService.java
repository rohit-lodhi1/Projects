package com.portal.app.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.portal.app.entity.User;
import com.portal.app.entity.exam.Ranks;
import com.portal.app.entity.exam.Result;

public interface IResultService {
   public Result save(Result result);
   public Result getResult(Integer id);
   public List<Result> getResultByUid(Long id);
   public List<Result> getAllResult();
   
   public Page<Result> getResultByPage(Integer pageNo,Integer pageSize);
   
   public List<User> getUserByResult(Long qid);
   
   public Ranks getRanks();
   
   public Boolean deleteResultById(Integer id);
   
   public Ranks getRanksByQuiz(Long id);
   
}
