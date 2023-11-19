package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.DeliveryAddress;

public interface DeliveryDao {
	
	// 배송 리스트 조회
	List<DeliveryAddress> getDeliveryAddress(String id);
	
	// 배송지 하나만 조회
	DeliveryAddress getDeliveryAddressOne(int id);
	
	// 배송지 등록
	void writeDeliveryAddress(DeliveryAddress deliveryAddress);
	
	// 배송지 수정
	void updateDeliveryAddress(DeliveryAddress deliveryAddress);
	
	// 배송지 삭제
	void removeDelivery(int id);

}
