package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Player;
import com.ssafy.video.model.dto.Product;
import com.ssafy.video.model.dto.ProductHeart;
import com.ssafy.video.model.dto.ProductOption;
import com.ssafy.video.model.dto.ProductShoppingBasket;
import com.ssafy.video.model.dto.ProductSize;
import com.ssafy.video.model.dto.User;


public interface ProductService {
	
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
	
	// 상품 아이디에 해당하는 사이즈 조회
	List<ProductSize> getProductSize(int id);

	// 상품 아이디에 해당하는 옵션 조회
	List<ProductOption> getProductOption(int id);

	// 선수 리스트 조회
	List<Player> getPlayerList();

	// 자체제작 상품 전체 리스트
	List<Product> getHandmade();

	// 인기있는 자체제작 상품
	List<Product> getHandmadebest();

	// 인기있는 판매자
	List<User> getSellerbest();

	// 인기있는 판매자 상품 리스트
	List<Product> getSellerHandmadebest(String registId);
	

}
