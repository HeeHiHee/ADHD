package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Product;
import com.ssafy.video.model.dto.ProductHeart;
import com.ssafy.video.model.dto.ProductShoppingBasket;


public interface ProductService {
	
	// 분류별 상품 조회
	List<Product> getCategoryProduct(int id);
	
	// 인기 상품 조회
	List<Product> getBestProduct();
	
	// 최근 상품 조회
	List<Product> getLatelyProduct();
	
	// 장바구니에 상품 등록
	void writeBasket(ProductShoppingBasket productShoppingBasket);
	
	// 찜 상품 등록
	void writeHeart(ProductHeart productHeart);

}
