package com.ssafy.video.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.ProductHeart;
import com.ssafy.video.model.dto.ProductShoppingBasket;
import com.ssafy.video.model.service.BasketService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/basket")
@Api(tags = "장바구니 상품 컨트롤러")
public class ProductBasketController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private BasketService bService;
	
	// 장바구니 상품 등록
	@ApiOperation("장바구니 상품 등록")
	@PostMapping("")
	public ResponseEntity<ProductShoppingBasket> basketWrite(@RequestBody ProductShoppingBasket productShoppingBasket){
		bService.writeBasket(productShoppingBasket);
		return new ResponseEntity<ProductShoppingBasket>(productShoppingBasket, HttpStatus.OK);
	}
	
	// 유저 아이디에 해당하는 장바구니 상품 리스트 조회
	@ApiOperation("유저 아이디에 해당하는 장바구니 상품 리스트 조회")
	@GetMapping("/list/{id}")
	public ResponseEntity<List<ProductShoppingBasket>> basketList(@PathVariable String id){
		List<ProductShoppingBasket> basketList =  bService.getBasketList(id);
		return new ResponseEntity<List<ProductShoppingBasket>>(basketList, HttpStatus.OK);
	}
	
	// 장바구니 상품 아이디에 해당하는 상품 하나 조회
	@ApiOperation("장바구니 상품 아이디에 해당하는 상품 하나 조회")
	@GetMapping("/{id}")
	public ResponseEntity<ProductShoppingBasket> basketListOne(@PathVariable int id){
		ProductShoppingBasket basketListOne = bService.getBasketHeartOne(id);
		return new ResponseEntity<ProductShoppingBasket>(basketListOne, HttpStatus.OK);		
	}
	
	// 장바구니 상품 아이디에 해당하는 상품 삭제
	@ApiOperation("장바구니 상품 아이디에 해당하는 상품 삭제")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> ProductBasketRemove(@PathVariable int id){
		bService.removeProductBasket(id);
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	
	
	
	

}
