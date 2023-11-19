package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.BasketDao;
import com.ssafy.video.model.dto.ProductShoppingBasket;

@Service
public class BasketServiceImpl implements BasketService {
	
	// 의존성 주입
	@Autowired
	private BasketDao dao;
	
	// 장바구니 상품 등록
	@Override
	public void writeBasket(ProductShoppingBasket productShoppingBasket) {
		dao.writeBasket(productShoppingBasket);
		
	}
	
	// 유저 아이디에 해당하는 장바구니 상품 리스트 조회
	@Override
	public List<ProductShoppingBasket> getBasketList(String id) {
		return dao.getBasketList(id);
	}
	
	// 장바구니 상품 아이디에 해당하는 상품 하나 조회
	@Override
	public ProductShoppingBasket getBasketHeartOne(int id) {
		return dao.getBasketHeartOne(id);
	}

	// 장바구니 상품 아이디에 해당하는 상품 삭제
	@Override
	public void removeProductBasket(int id) {
		dao.removeProductBasket(id);
	}
	
		
	


	
	

}
