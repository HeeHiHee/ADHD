package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.OrderDao;
import com.ssafy.video.model.dto.ProductOrder;

@Service
public class OrderServiceImpl implements OrderService {
	
	// 의존성 주입
	@Autowired
	private OrderDao dao;
	
	// 주문내역 등록 
	@Override
	public void writeOrder(ProductOrder order) {
		dao.writeOrder(order);
	}
	
	// 리뷰 리스트 조회
	@Override
	public List<ProductOrder> getOrderList() {
		return dao.getOrderList();
	}
	
	// 유저 아이디에 맞는 주문 내역 조회
	@Override
	public List<ProductOrder> getOrderUserList(String userId) {
		return dao.getOrderUserList(userId);
	}
	
	// 상품 아이디에 맞는 주문 내역 조회
	@Override
	public List<ProductOrder> getOrderProductList(int productId) {
		return dao.getOrderProductList(productId);
	}
	
	// 주문 내역 수정
	@Override
	public void updateOrder(ProductOrder productOrder) {
		dao.updateOrder(productOrder);
	}
	
	

}
