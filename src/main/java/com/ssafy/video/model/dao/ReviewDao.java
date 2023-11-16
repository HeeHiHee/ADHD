package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.Review;

public interface ReviewDao {
	
	List<Review> select();
	
	List<Review> selectList(String videoid);
	
	void insertReview(Review review);
	
	Review selectOne(int reviewid);
	
	void updateReview(Review review);
	
	void deleteReview(int reviewid);
	
	void updateViewCnt(int reviewid);
}
