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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.Review;
import com.ssafy.video.model.service.ReviewService;
import com.ssafy.video.model.service.VideoService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api")
@Api(tags = "리뷰 컨트롤러")
public class ReviewController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ReviewService rService;
	
	
	@DeleteMapping("/review/{id}")
	public ResponseEntity<Void> doRemove(@PathVariable int id){
		rService.removeReview(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


	@PutMapping("/review/update")
	public ResponseEntity<Void> doUpdate(@RequestBody Review review){
		
		rService.modifyReview(review);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

	@GetMapping("/review/{id}")
	public ResponseEntity<Review> doDetail(@PathVariable int id) {
		Review review = rService.getOneReview(id);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
		
	}
	@PostMapping("/review")
	public ResponseEntity<Review> doWrite(@RequestBody Review review){
		rService.writeReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
		
	}

	@GetMapping("/reviewlist/{id}")
	public ResponseEntity<List<Review>> doList(@PathVariable String id){
		List<Review> reviewList = rService.getReview(id);
		return new ResponseEntity<List<Review>>(reviewList,HttpStatus.OK);
		
	}
}
