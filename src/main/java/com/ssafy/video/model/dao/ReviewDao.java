package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.Review;

public interface ReviewDao {
	
	// 리뷰 전체 리스트 조회
	List<Review> getReview();
	
	// 문의 전체 리스트 조회
	List<Review> getQuestion();
	
//	List<Review> selectList(String videoid);
	
	// 리뷰 등록
	void writeReview(Review review);
	
//	Review selectOne(int reviewid);
	
	// 리뷰 수정
	void updateReview(Review review);
	
	// 리뷰 삭제
	void removeReview(int reviewid);
	
	// 상품 아이디에 해당되는 리뷰 리스트 조회
	List<Review> getProductReview(int productId);
	
	// 상품 아이디에 해당되는 문의 리스트 조회
	List<Review> getProductQuestion(int productId);
	
//	void updateViewCnt(int reviewid);
}
