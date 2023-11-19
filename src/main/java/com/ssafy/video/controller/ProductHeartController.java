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
import com.ssafy.video.model.service.HeartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "찜 상품 컨트롤러")
public class ProductHeartController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private HeartService hService;
	
	// 찜 상품 등록
	@ApiOperation("찜 상품 등록")
	@PostMapping("/heart")
	public ResponseEntity<ProductHeart> heartWrite(@RequestBody ProductHeart productHeart){
		hService.writeHeart(productHeart);
		return new ResponseEntity<ProductHeart>(productHeart, HttpStatus.OK);
	}
	
	// 유저 아이디에 해당하는 찜 상품 리스트
	@ApiOperation("유저 아이디에 해당하는 찜 상품 리스트")
	@GetMapping("/heart/list/{id}")
	public ResponseEntity<List<ProductHeart>> heartList(@PathVariable String id){
		List<ProductHeart> heartList =  hService.getHeartList(id);
		return new ResponseEntity<List<ProductHeart>>(heartList, HttpStatus.OK);
	}
	
	// 찜 상품 아이디에 해당하는 찜 상품 하나만 조회
	@ApiOperation("찜 상품(heartId) 아이디에 해당하는 찜 상품 하나만 조회")
	@GetMapping("/heart/{id}")
	public ResponseEntity<ProductHeart> heartListOne(@PathVariable int id){
		ProductHeart productHeart = hService.getProductHeartOne(id);
		return new ResponseEntity<ProductHeart>(productHeart, HttpStatus.OK);		
	}
	
	// 찜 상품 아이디에 해당하는 찜 상품 삭제
	@ApiOperation("찜 상품(heartId) 아이디에 해당하는 찜 상품 삭제")
	@DeleteMapping("/heart/{id}")
	public ResponseEntity<Void> ProductHeartRemove(@PathVariable int id){
		hService.removeProductHeart(id);
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	
	

}
