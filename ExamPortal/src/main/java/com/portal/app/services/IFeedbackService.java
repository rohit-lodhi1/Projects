package com.portal.app.services;

import org.springframework.data.domain.Page;

import com.portal.app.entity.Feedback;

public interface IFeedbackService {
   public Page<Feedback> getFeedback(Integer pageNo,Integer pageSize);
   
   public boolean deleteFeedBack(Integer id);
   
   public Feedback submit(Feedback feedback);
}
