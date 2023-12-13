package com.portal.app.services.Implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.app.Repository.IFeedBackReposiotry;
import com.portal.app.entity.Feedback;
import com.portal.app.services.IFeedbackService;


@Service
public class FeedBackServiceImpl implements IFeedbackService{

	@Autowired
	private IFeedBackReposiotry feedbackRepo;
	
	@Override
	public Page<Feedback> getFeedback(Integer pageNo,Integer pageSize) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		      Page<Feedback> resultPage = this.feedbackRepo.findAll(page);
		return resultPage;
	}

	@Override
	public boolean deleteFeedBack(Integer id) {
		// TODO Auto-generated method stub
		this.feedbackRepo.deleteById(id);
		return true;
	}

	@Override
	public Feedback submit(Feedback feedback) {
		// TODO Auto-generated method stub
		return this.feedbackRepo.save(feedback);
	}

}
