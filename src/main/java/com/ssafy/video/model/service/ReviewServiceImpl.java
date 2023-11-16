package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.ReviewDao;
import com.ssafy.video.model.dto.Review;
@Service
public class ReviewServiceImpl implements ReviewService {
	private static ReviewService reviewservice = new ReviewServiceImpl();

	
	//의존성 주입
	@Autowired
	private ReviewDao dao;
	
	
	private ReviewServiceImpl() {
	}
	
	public static ReviewService getInstance() {
		return reviewservice;
	}
	
	
	@Override
	public List<Review> getList() {
		return dao.select();
	}

	@Override
	public void writeReview(Review review) {
		dao.insertReview(review);
	}

	@Override
	public List<Review> getReview(String videoid) {
		return dao.selectList(videoid);
	}
	
	@Override
	public Review getOneReview(int id) {
		dao.updateViewCnt(id);
		return dao.selectOne(id);
	}


	@Override
	public void modifyReview(Review review) {
		dao.updateReview(review);
	}

	@Override
	public void removeReview(int id) {
		dao.deleteReview(id);
	}



	
}
