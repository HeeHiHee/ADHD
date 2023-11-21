package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Review;


public interface ReviewService {
	
		// 리뷰 전체 조회
		List<Review> getReview();
		
		// 문의 전체 조회
		List<Review> getQuestion();

		// 리뷰 등록
		void writeReview(Review review);

//		// 게시글 상세 조회
//		List<Review> getReview(String id);

		// 리뷰 수정
		void updateReview(Review review);

		// 리뷰 삭제
		void removeReview(int id);
		
		// 상품 아이디에 해당되는 리뷰 리스트 조회
		List<Review> getProductReview(int productId);
		
		// 상품 아이디에 해당되는 문의 리스트 조회
		List<Review> getProductQuestion(int productId);
		
		// 유저 아이디에 해당되는 리뷰 리스트 조회
		List<Review> getUserReview(String userId);

		// 유저 아이디에 해당되는 문의 리스트 조회
		List<Review> getUserQuestion(String userId);

//		Review getOneReview(int id);
}
