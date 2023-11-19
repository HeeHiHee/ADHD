package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.ProductDao;
import com.ssafy.video.model.dto.Product;
import com.ssafy.video.model.dto.ProductHeart;
import com.ssafy.video.model.dto.ProductShoppingBasket;

@Service
public class ProductServiceImpl implements ProductService {
	
	// 의존성 주입
	@Autowired
	private ProductDao dao;
	
	// 상품 등록
	@Override
	public void writeProduct(Product product) {
		dao.writeProduct(product);
		
	}
	
	// 상품 정보 수정
	@Override
	public void updateProduct(Product product) {
		dao.updateProduct(product);
		
	}
	
	// 상품 번호에 해당하는 상품 삭제
	@Override
	public void removeProduct(int id) {
		dao.removeProduct(id);
		
	}
	
	// 분류별 상품 조회
	@Override
	public List<Product> getCategoryProduct(int id) {
		return dao.getCategoryProduct(id);
	}
	
	// 상품 하나 조회
	@Override
	public Product getProductOne(int id) {
		return dao.getProductOne(id);
	}
	
	// 인기상품 조회
	@Override
	public List<Product> getBestProduct(){
		return dao.getBestProduct();
	}
	
	// 최근 상품 조회
	@Override
	public List<Product> getLatelyProduct() {
		return dao.getLatelyProduct();
	}

	
	

}
