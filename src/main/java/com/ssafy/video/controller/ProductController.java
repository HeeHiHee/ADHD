package com.ssafy.video.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.Product;
import com.ssafy.video.model.dto.Review;
import com.ssafy.video.model.service.ProductService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(tags = "상품 컨트롤러")
public class ProductController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductService pService;
	
	@GetMapping("/product/list/{id}")
	public ResponseEntity<List<Product>> doList(@PathVariable int id){
		List<Product> productList = pService.getCategoryProduct(id);
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
		
	}

}
