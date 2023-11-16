package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.ProductDao;
import com.ssafy.video.model.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	// 의존성 주입
	@Autowired
	private ProductDao dao;

	@Override
	public List<Product> getCategoryProduct(int id) {
		return dao.getCategoryProduct(id);
	}
	

}
