package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.DeliveryDao;
import com.ssafy.video.model.dto.DeliveryAddress;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	// 의존성 주입
	@Autowired
	private DeliveryDao dao;
	
	// 배송 리스트 조회
	@Override
	public List<DeliveryAddress> getDeliveryAddress(String id) {
		return dao.getDeliveryAddress(id);
	}
	
	// 배송지 하나만 조회
	@Override
	public DeliveryAddress getDeliveryAddressOne(int id) {
		return dao.getDeliveryAddressOne(id);
	}
	
	// 배송지 등록
	@Override
	public void writeDeliveryAddress(DeliveryAddress deliveryAddress) {
		dao.writeDeliveryAddress(deliveryAddress);
		
	}

	// 배송지 수정
	@Override
	public void updateDeliveryAddress(DeliveryAddress deliveryAddress) {
		dao.updateDeliveryAddress(deliveryAddress);
		
	}
	
	// 배송지 삭제
	@Override
	public void removeDelivery(int id) {
		dao.removeDelivery(id);
		
	} 
	

}
