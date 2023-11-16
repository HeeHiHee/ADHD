package com.ssafy.video.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.Video;
import com.ssafy.video.model.service.ReviewService;
import com.ssafy.video.model.service.VideoService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api")
//@CrossOrigin("*")
@Api(tags = "영상 컨트롤러")
public class VideoController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		// 의존성 주입
		@Autowired
		private VideoService vService;
		
		@Autowired
		private ReviewService rService;
		
		
		
		@GetMapping("/video")
		public ResponseEntity<List<Video>> doList(){
			List<Video> videoList = vService.getList();
			return new ResponseEntity<List<Video>>(videoList,HttpStatus.OK);
			
			
		}
		@GetMapping("/video/{fitPartName}")
		public ResponseEntity<List<Video>> doPartList(@PathVariable String fitPartName){
			List<Video> videoList = vService.getPartList(fitPartName);
			return new ResponseEntity<List<Video>>(videoList,HttpStatus.OK);
			
		}
		
		@GetMapping("/videolist/{id}")
		public ResponseEntity<Video> detail(@PathVariable String id){
			Video video = vService.getOne(id);
			return new ResponseEntity<Video>(video, HttpStatus.OK);
					
		}
		
		
		
}
