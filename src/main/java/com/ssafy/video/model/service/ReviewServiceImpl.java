package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.ReviewDao;
import com.ssafy.video.model.dto.Review;
@Service
public class ReviewServiceImpl implements ReviewService {
//	private static ReviewService reviewservice = new ReviewServiceImpl();

	
	//의존성 주입
	@Autowired
	private ReviewDao dao;
	
	
//	private ReviewServiceImpl() {
//	}
//	
//	public static ReviewService getInstance() {
//		return reviewservice;
//	}
	
	// 리뷰 전체 조회
	@Override
	public List<Review> getReview() {
		return dao.getReview();
	}
	
	// 리뷰 전체 조회
	@Override
	public List<Review> getQuestion() {
		return dao.getQuestion();
	}
	
	// 리뷰 등록
	@Override
	public void writeReview(Review review) {
		dao.writeReview(review);
	}
	
//	@Override
//	public List<Review> getReview(String videoid) {
//		return dao.selectList(videoid);
//	}
//	
//	@Override
//	public Review getOneReview(int id) {
//		dao.updateViewCnt(id);
//		return dao.selectOne(id);
//	}

	// 리뷰 수정
	@Override
	public void updateReview(Review review) {
		dao.updateReview(review);
	}
	
	// 리뷰 삭제
	@Override
	public void removeReview(int id) {
		dao.removeReview(id);
	}



	
}
