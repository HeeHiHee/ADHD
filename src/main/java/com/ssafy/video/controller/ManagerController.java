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

import com.ssafy.video.model.dto.Manager;
import com.ssafy.video.model.dto.Review;
import com.ssafy.video.model.service.ManagerService;
import com.ssafy.video.model.service.ReviewService;
import com.ssafy.video.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(tags = "관리자 컨트롤러")
public class ManagerController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ManagerService mService;
	
	// 관리자 삭제
	@ApiOperation("관리자 삭제")
	@PutMapping("/manager/{id}")
	public ResponseEntity<Void> managerRemove(@PathVariable String id){
		mService.removeManager(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 관리자 수정
	@ApiOperation("관리자 수정")
	@PutMapping("/manager/update")
	public ResponseEntity<Void> managerUpdate(@RequestBody Manager manager){		
		mService.updateManager(manager);		
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	// 관리자 등록
	@ApiOperation("관리자 등록")
	@PostMapping("/manager")
	public ResponseEntity<Manager> managerWrite(@RequestBody Manager manager){
		mService.writeManager(manager);
		return new ResponseEntity<Manager>(manager, HttpStatus.OK);
		
	}
	
	// 관리자 리스트 조회
	@ApiOperation("관리자 리스트 조회")
	@GetMapping("/managerlist")
	public ResponseEntity<List<Manager>> managerList(){
		List<Manager> managerList = mService.getManagerList();
		return new ResponseEntity<List<Manager>>(managerList,HttpStatus.OK);		
	}
}
