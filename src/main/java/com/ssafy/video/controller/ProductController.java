package com.ssafy.video.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.Player;
import com.ssafy.video.model.dto.Product;
import com.ssafy.video.model.dto.ProductOption;
import com.ssafy.video.model.dto.ProductSize;
import com.ssafy.video.model.dto.User;
import com.ssafy.video.model.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/product")
@Api(tags = "상품 컨트롤러")
public class ProductController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductService pService;
	
	// 상품 등록
	@ApiOperation("상품 등록")
	@PostMapping("")
	public ResponseEntity<Product> productWrite(@RequestBody Product product){
		pService.writeProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	// 상품 정보 수정
	@ApiOperation("상품 정보 수정")
	@PutMapping("/update")
	public ResponseEntity<Void> productUpdate(@RequestBody Product product){
		pService.updateProduct(product);		
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	// 상품 번호에 해당하는 상품 삭제
	@ApiOperation("상품 번호에 해당하는 상품 삭제")
	@PutMapping("/{id}")
	public ResponseEntity<Void> productRemove(@PathVariable int id){
		pService.removeProduct(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	// 카테고리에 해당하는 상품 리스트 추출
	@ApiOperation("카테고리에 해당하는 상품 리스트 추출")
	@GetMapping("/list/{id}")
	public ResponseEntity<List<Product>> productList1(@PathVariable int id){
		List<Product> productList = pService.getCategoryProduct(id);
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);		
	}
	
	// 상품 하나만 추출
	@ApiOperation("상품 하나만 추출")
	@GetMapping("/{id}")
	public ResponseEntity<Product> productList2(@PathVariable int id){
		Product product = pService.getProductOne(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);		
	}
	
	// 인기상품 리스트 추출
	@ApiOperation("인기상품 리스트 추출")
	@GetMapping("/bestProducts")
	public ResponseEntity<List<Product>> productList1(){
		List<Product> productList = pService.getBestProduct();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);		
	} 
	
	
	// 최근 등록 상품 리스트 추출
	@ApiOperation("최근 등록 상품 리스트 추출")
	@GetMapping("/latelyProducts")
	public ResponseEntity<List<Product>> productList2(){
		List<Product> productList = pService.getLatelyProduct();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);		
	}
	
	// 상품 아이디에 해당하는 사이즈 조회
	@ApiOperation(value = "사이즈 조회", notes = "상품 아이디에 해당하는 사이즈 조회")
	@GetMapping("/size/{id}")
	public ResponseEntity<List<ProductSize>> productSizeList(@PathVariable int id){
		List<ProductSize> productSizeList = pService.getProductSize(id);
		return new ResponseEntity<List<ProductSize>>(productSizeList,HttpStatus.OK);
	}
		
	// 상품 아이디에 해당하는 옵션 조회
	@ApiOperation(value = "옵션 조회", notes = "상품 아이디에 해당하는 옵션 조회")
	@GetMapping("/option/{id}")
	public ResponseEntity<List<ProductOption>> productOptionList(@PathVariable int id){
		List<ProductOption> productOptionList = pService.getProductOption(id);
		return new ResponseEntity<List<ProductOption>>(productOptionList,HttpStatus.OK);
	}
	
	// 선수 리스트 조회
	@ApiOperation(value = "선수 전체 리스트 조회")
	@GetMapping("/playerList")
	public ResponseEntity<List<Player>> playerList(){
		List<Player> playerList = pService.getPlayerList();
		return new ResponseEntity<List<Player>>(playerList,HttpStatus.OK);		
	}
	
	// 자체제작 상품 전체 리스트
	@ApiOperation(value = "자체제작 상품 전체 리스트")
	@GetMapping("/handmadeList")
	public ResponseEntity<List<Product>> handmadeList(){
		List<Product> handmadeList = pService.getHandmade();
		return new ResponseEntity<List<Product>>(handmadeList,HttpStatus.OK);
	}
	
	// 인기있는 자체제작 상품
	@ApiOperation(value = "인기있는 자체제작 상품 리스트", notes = "자체제작 상품 중 구매량 높은 순 10개 조회")
	@GetMapping("/bestHandmadeList")
	public ResponseEntity<List<Product>> bestHandmadeList(){
		List<Product> bestHandmadeList = pService.getHandmadebest();
		return new ResponseEntity<List<Product>>(bestHandmadeList,HttpStatus.OK);
	}
	
	// 인기있는 판매자
	@ApiOperation(value = "인기있는 판매자 3명", notes = "자체제작 상품 중 판매량 높은 순 3명 조회")
	@GetMapping("/bestSellerList")
	public ResponseEntity<List<User>> bestSellerList(){
		List<User> bestSellerList = pService.getSellerbest();
		return new ResponseEntity<List<User>>(bestSellerList,HttpStatus.OK);
	}
	
	// 인기있는 판매자 상품 리스트
	@ApiOperation(value = "인기있는 판매자 상품 리스트")
	@GetMapping("/bestSellerHandmadeList")
	public ResponseEntity<List<Product>> bestSellerHandemadeList(String registId){
		List<Product> bestSellerHandemadeList = pService.getSellerHandmadebest(registId);
		return new ResponseEntity<List<Product>>(bestSellerHandemadeList,HttpStatus.OK);
	}

}
