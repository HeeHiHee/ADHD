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

//		Review getOneReview(int id);
}
