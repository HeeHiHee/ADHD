package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.ProductHeart;

public interface HeartDao {
	
	// 찜 상품 등록
	void writeHeart(ProductHeart productHeart);
	
	// 한 유저가 가지고 있는 찜 상품 리스트 조회
	List<ProductHeart> getHeartList(String id);
	
	// 찜 상품 하나만 조회
	ProductHeart getProductHeartOne(int id);
	
	// 찜 상품 삭제
	void removeProductHeart(int id);

}
