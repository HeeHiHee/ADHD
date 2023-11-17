package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.DeliveryAddress;

public interface DeliveryService {
	
	// 유저 아이디에 해당하는 배송지 리스트 조회
	List<DeliveryAddress> getDeliveryAddress(int id);
	
	// 배송지 아이디에 해당하는 배송지 하나만 조회
	DeliveryAddress getDeliveryAddressOne(int id);
	
	// 새로운 배송지 등록
	void writeDeliveryAddress(DeliveryAddress deliveryAddress);
	
	// 배송지 수정
	void updateDeliveryAddress(DeliveryAddress deliveryAddress);
	
	// 배송지 삭제
	void removeDelivery(int id);

}
