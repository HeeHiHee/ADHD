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

import com.ssafy.video.model.dto.DeliveryAddress;
import com.ssafy.video.model.service.DeliveryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/api")
@Api(tags = "상품 배송 컨트롤러")
public class DeliveryController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DeliveryService dService;
	
	// 유저 아이디에 해당하는 배송지 리스트 추출
	@ApiOperation("유저 아이디에 해당하는 배송지 리스트 추출")
	@GetMapping("/deliveryList/{id}")
	public ResponseEntity<List<DeliveryAddress>> deliveryList1(@PathVariable String id){
		List<DeliveryAddress> deliveryList = dService.getDeliveryAddress(id);
		return new ResponseEntity<List<DeliveryAddress>>(deliveryList,HttpStatus.OK);		
	}
	
	// 배송지 아이디에 해당하는 배송지 하나만 추출
	@ApiOperation("배송 아이디에 해당하는 배송지 하나만 추출")
	@GetMapping("/deliveryOne/{id}")
	public ResponseEntity<DeliveryAddress> productList2(@PathVariable int id){
		DeliveryAddress delivery = dService.getDeliveryAddressOne(id);
		return new ResponseEntity<DeliveryAddress>(delivery, HttpStatus.OK);		
	}	
	
	// 배송지 등록
	@ApiOperation("배송지 등록")
	@PostMapping("/deliveryList")
	public ResponseEntity<DeliveryAddress> doDeliveryWrite(@RequestBody DeliveryAddress deliveryAddress){
		dService.writeDeliveryAddress(deliveryAddress);
		return new ResponseEntity<DeliveryAddress>(deliveryAddress, HttpStatus.OK);
	}
	
	// 배송지 수정
	@ApiOperation("배송 아이디에 해당하는 배송지 수정")
	@PostMapping("/deliveryList/update")
	public ResponseEntity<Void> DeliveryUpdate(@RequestBody DeliveryAddress deliveryAddress){
		dService.updateDeliveryAddress(deliveryAddress);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 배송지 아이디에 해당하는 배송지 삭제
	@ApiOperation("배송지 아이디에 해당하는 배송지 삭제")
	@DeleteMapping("/deliveryList/{id}")
	public ResponseEntity<Void> DeliveryRemove(@PathVariable int id){
		dService.removeDelivery(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	

}
