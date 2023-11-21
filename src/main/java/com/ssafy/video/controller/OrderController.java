package com.ssafy.video.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.ProductOrder;
import com.ssafy.video.model.dto.Review;
import com.ssafy.video.model.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "주문 컨트롤러")
public class OrderController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private OrderService oService;
	
	// 주문 내역 등록
	@ApiOperation(value = "주문 내역 등록", notes = "주문이 완료된 내역들을 db에 저장")
	@PostMapping("/order")
	public ResponseEntity<?> OrderWrite(@RequestBody List<ProductOrder> orderList){
		for(ProductOrder order : orderList) {
			oService.writeOrder(order);
		}
		return new ResponseEntity<>("List processed successfully", HttpStatus.OK);		
	}
	
	// 리뷰 리스트 조회
	@ApiOperation(value = "주문 내역 전체 조회", notes = "모든 주문 내역을 조회함")
	@GetMapping("/orderList")
	public ResponseEntity<List<ProductOrder>> OrderList(){
		List<ProductOrder> orderList = oService.getOrderList();
		return new ResponseEntity<List<ProductOrder>>(orderList,HttpStatus.OK);		
	}
	
	// 유저 아이디에 맞는 주문 내역 조회
	@ApiOperation(value = "해당 유저 주문 내역 조회", notes = "유저 아이디에 맞는 주문 내역 조회")
	@GetMapping("/orderUserList")
	public ResponseEntity<List<ProductOrder>> OrderUserList(String userId){
		List<ProductOrder> orderUserList = oService.getOrderUserList(userId);
		return new ResponseEntity<List<ProductOrder>>(orderUserList,HttpStatus.OK);		
	}
	
	// 상품 아이디에 맞는 주문 내역 조회
	@ApiOperation(value = "해당 상품 주문 내역 조회", notes = "상품 아이디에 맞는 주문 내역 조회")
	@GetMapping("/orderProductList")
	public ResponseEntity<List<ProductOrder>> OrderProductList(int productId){
		List<ProductOrder> orderProductList = oService.getOrderProductList(productId);
		return new ResponseEntity<List<ProductOrder>>(orderProductList,HttpStatus.OK);		
	}
	
	// 주문 내역 수정
	@ApiOperation(value = "주문 내역 수정", notes = "주문 아이디에 맞는 주문 내역 수정")
	@PutMapping("/order/update")
	public ResponseEntity<Void> orderUpdate(@RequestBody ProductOrder productOrder){		
		oService.updateOrder(productOrder);		
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
	
	
	

}
