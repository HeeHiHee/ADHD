package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.ProductOrder;

public interface OrderDao {
	
	// 주문 내역 등록
	void writeOrder(ProductOrder order);
	
	// 리뷰 리스트 조회
	List<ProductOrder> getOrderList();
	
	// 유저 아이디에 맞는 주문 내역 조회
	List<ProductOrder> getOrderUserList(String userId);
	
	// 상품 아이디에 맞는 주문 내역 조회
	List<ProductOrder> getOrderProductList(int productId);
	
	// 주문 내역 수정
	void updateOrder(ProductOrder productOrder);

}
