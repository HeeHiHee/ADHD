package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.HeartDao;
import com.ssafy.video.model.dto.ProductHeart;

@Service
public class HeartServiceImpl implements HeartService {
	
	// 의존성 주입
	@Autowired
	private HeartDao dao;
	
	// 찜 상품 등록
	@Override
	public void writeHeart(ProductHeart productHeart) {
		dao.writeHeart(productHeart);
		
	}
	
	// 한 유저가 가지고 있는 찜 상품 리스트 조회
	@Override
	public List<ProductHeart> getHeartList(String id) {
		return dao.getHeartList(id);
	}
	
	// 찜 상품 하나만 조회
	@Override
	public ProductHeart getProductHeartOne(int id) {
		return dao.getProductHeartOne(id);
	}
	
	// 찜 상품 삭제
	@Override
	public void removeProductHeart(int id) {
		dao.removeProductHeart(id);
		
	}
	
	
	


	
	

}
