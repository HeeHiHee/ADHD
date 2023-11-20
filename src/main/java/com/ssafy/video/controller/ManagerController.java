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

import com.ssafy.video.model.dto.Manager;
import com.ssafy.video.model.dto.ManagerComment;
import com.ssafy.video.model.service.ManagerService;

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
	
	// 관리자 댓글 등록
	@ApiOperation("관리자 댓글 등록")
	@PostMapping("/managercomment")
	public ResponseEntity<ManagerComment> managerCommentWrite(@RequestBody ManagerComment managerComment){
		mService.writeManagerComment(managerComment);
		return new ResponseEntity<ManagerComment>(managerComment, HttpStatus.OK);
		
	}
	
	// 관리자 아이디에 해당하는 댓글 리스트 가져오기
	@ApiOperation("관리자 아이디에 해당하는 댓글 리스트 가져오기")
	@GetMapping("/managercommentlist")
	public ResponseEntity<List<ManagerComment>> managerCommentList(String managerId){
		List<ManagerComment> managerCommentList = mService.getManagerCommentList(managerId);
		return new ResponseEntity<List<ManagerComment>>(managerCommentList,HttpStatus.OK);		
	}
	
	// 관리자 댓글 수정
	@ApiOperation("관리자 수정")
	@PutMapping("/managercomment/update")
	public ResponseEntity<Void> managerCommentUpdate(@RequestBody ManagerComment managerComment){		
		mService.updateManagerComment(managerComment);		
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	// 댓글 아이디에 맞는 관리자 댓글 하나 삭제
	@ApiOperation("댓글 아이디에 맞는 관리자 댓글 하나 삭제")
	@PutMapping("/managercomment/{id}")
	public ResponseEntity<Void> managerCommentRemove(@PathVariable int id){
		mService.removeManagerComment(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
