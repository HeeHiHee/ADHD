package com.ssafy.video.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.Product;
import com.ssafy.video.model.dto.ProductHeart;
import com.ssafy.video.model.dto.ProductShoppingBasket;
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
	
	// 카테고리에 해당하는 상품 리스트 추출
	@GetMapping("/product/list/{id}")
	public ResponseEntity<List<Product>> productList1(@PathVariable int id){
		List<Product> productList = pService.getCategoryProduct(id);
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);		
	}
	
	// 상품 하나만 추출
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> productList2(@PathVariable int id){
		Product product = pService.getProductOne(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);		
	}
	
	// 인기상품 리스트 추출
	@GetMapping("/product/bestProducts")
	public ResponseEntity<List<Product>> productList1(){
		List<Product> productList = pService.getBestProduct();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);		
	} 
	
	
	// 최근 등록 상품 리스트 추출
	@GetMapping("/product/latelyProducts")
	public ResponseEntity<List<Product>> productList2(){
		List<Product> productList = pService.getLatelyProduct();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);		
	}
	
	
	// 장바구니에 상품 등록
	@PostMapping("/product/shoppingBasket")
	public ResponseEntity<ProductShoppingBasket> basketWrite(@RequestBody ProductShoppingBasket productShoppingBasket){
		pService.writeBasket(productShoppingBasket);
		return new ResponseEntity<ProductShoppingBasket>(productShoppingBasket, HttpStatus.OK);
	}
	
	// 찜 상품 등록
	@PostMapping("/product/heart")
	public ResponseEntity<ProductHeart> heartWrite(@RequestBody ProductHeart productHeart){
		pService.writeHeart(productHeart);
		return new ResponseEntity<ProductHeart>(productHeart, HttpStatus.OK);
	}
	
	
	

}
