package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.Product;
import com.ssafy.video.model.dto.ProductHeart;
import com.ssafy.video.model.dto.ProductShoppingBasket;

public interface ProductDao {
	
	// 상품 등록
	void writeProduct(Product product);
	
	// 상품 정보 수정
	void updateProduct(Product product);
	
	// 상품 번호에 해당하는 상품 삭제
	void removeProduct(int id);
	
	// 분류별 상품 조회
	List<Product> getCategoryProduct(int id);
	
	// 상품 하나 조회
	Product getProductOne(int id);
	
	// 인기 상품 조회
	List<Product> getBestProduct();
	
	// 최근 상품 조회
	List<Product> getLatelyProduct();
	

}
