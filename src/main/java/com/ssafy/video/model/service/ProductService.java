package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.video.model.dto.Product;


public interface ProductService {
	
	// 분류별 상품 조회
	List<Product> getCategoryProduct(int id);

}
