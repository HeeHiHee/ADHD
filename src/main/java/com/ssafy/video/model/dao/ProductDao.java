package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.Product;

public interface ProductDao {

	List<Product> getCategoryProduct(int id);

}
