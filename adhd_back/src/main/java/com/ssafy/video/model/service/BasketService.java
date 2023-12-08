package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Product;
import com.ssafy.video.model.dto.ProductHeart;
import com.ssafy.video.model.dto.ProductShoppingBasket;


public interface BasketService {
	
	// 장바구니 상품 등록
	void writeBasket(ProductShoppingBasket productShoppingBasket);
	
	// 유저 아이디에 해당하는 장바구니 상품 리스트 조회
	List<ProductShoppingBasket> getBasketList(String id);
	
	// 장바구니 상품 아이디에 해당하는 상품 하나 조회
	ProductShoppingBasket getBasketHeartOne(int id);
	
	// 장바구니 상품 아이디에 해당하는 상품 삭제
	void removeProductBasket(int id);
	

}
