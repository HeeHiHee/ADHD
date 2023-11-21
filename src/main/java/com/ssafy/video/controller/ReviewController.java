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

import com.ssafy.video.model.dto.Review;
import com.ssafy.video.model.service.ManagerService;
import com.ssafy.video.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/review")
@Api(tags = "리뷰 컨트롤러")
public class ReviewController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReviewService rService;
	
	@Autowired
	private ManagerService mService;
	
	// 리뷰 번호에 해당하는 리뷰 삭제
	@ApiOperation("리뷰/문의 번호에 해당하는 리뷰/문의 삭제")
	@PutMapping("/{id}")
	public ResponseEntity<Void> reviewRemove(@PathVariable int id){
		rService.removeReview(id);
		mService.removeManagerComment(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 리뷰 수정
	@ApiOperation("리뷰/문의 수정")
	@PutMapping("/update")
	public ResponseEntity<Void> reviewUpdate(@RequestBody Review review){		
		rService.updateReview(review);		
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
	
//	@GetMapping("/review/{id}")
//	public ResponseEntity<Review> doDetail(@PathVariable int id) {
//		Review review = rService.getOneReview(id);
//		return new ResponseEntity<Review>(review, HttpStatus.OK);		
//	}
	
	// 리뷰 등록
	@ApiOperation("리뷰/문의 등록")
	@PostMapping("")
	public ResponseEntity<Review> ReviewWrite(@RequestBody Review review){
		rService.writeReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
		
	}
	
	// 리뷰 리스트 조회
	@ApiOperation("리뷰 리스트 조회")
	@GetMapping("/reviewlist")
	public ResponseEntity<List<Review>> ReviewList(){
		List<Review> reviewList = rService.getReview();
		return new ResponseEntity<List<Review>>(reviewList,HttpStatus.OK);		
	}
	
	// 문의 리스트 조회
	@ApiOperation("문의 리스트 조회")
	@GetMapping("/questionlist")
	public ResponseEntity<List<Review>> QuestionList(){
		List<Review> questionList = rService.getQuestion();
		return new ResponseEntity<List<Review>>(questionList,HttpStatus.OK);		
	}
	
	// 상품 아이디에 해당되는 리뷰 리스트 조회
	@ApiOperation("상품 아이디에 해당되는 리뷰 리스트 조회")
	@GetMapping("/productReviewList")
	public ResponseEntity<List<Review>> ProductReviewList(int productId){
		List<Review> productReviewList = rService.getProductReview(productId);
		return new ResponseEntity<List<Review>>(productReviewList,HttpStatus.OK);		
	}
	
	// 상품 아이디에 해당되는 문의 리스트 조회
	@ApiOperation("상품 아이디에 해당되는 문의 리스트 조회")
	@GetMapping("/productQuestionList")
	public ResponseEntity<List<Review>> ProductQuestionList(int productId){
		List<Review> productQuestionList = rService.getProductQuestion(productId);
		return new ResponseEntity<List<Review>>(productQuestionList,HttpStatus.OK);		
	}
	
	// 유저 아이디에 해당되는 리뷰 리스트 조회
	@ApiOperation("유저 아이디에 해당되는 리뷰 리스트 조회")
	@GetMapping("/userReviewList")
	public ResponseEntity<List<Review>> UserReviewList(String userId){
		List<Review> userReviewList = rService.getUserReview(userId);
		return new ResponseEntity<List<Review>>(userReviewList,HttpStatus.OK);		
	}
	
	// 유저 아이디에 해당되는 문의 리스트 조회
	@ApiOperation("유저 아이디에 해당되는 문의 리스트 조회")
	@GetMapping("/userQuestionList")
	public ResponseEntity<List<Review>> UserQuestionList(String userId){
		List<Review> userQuestionList = rService.getUserQuestion(userId);
		return new ResponseEntity<List<Review>>(userQuestionList,HttpStatus.OK);		
	}
}
