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
import com.ssafy.video.model.dto.ManagerNotice;
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
	@ApiOperation(value = "관리자 리스트 조회", notes = "관리자 리스트 조회")
	@GetMapping("/managerlist")
	public ResponseEntity<List<Manager>> managerList(){
		List<Manager> managerList = mService.getManagerList();
		return new ResponseEntity<List<Manager>>(managerList,HttpStatus.OK);		
	}
	
	/**
	 * 
	 */
	
	// 관리자 댓글 등록
	@ApiOperation(value = "관리자 댓글 등록", notes = "관리자 댓글 등록")
	@PostMapping("/managercomment")
	public ResponseEntity<ManagerComment> managerCommentWrite(@RequestBody ManagerComment managerComment){
		mService.writeManagerComment(managerComment);
		return new ResponseEntity<ManagerComment>(managerComment, HttpStatus.OK);		
	}
	
	// 관리자 아이디에 해당하는 댓글 리스트 가져오기
	@ApiOperation(value = "관리자 댓글 리스트 조회", notes = "관리자 아이디에 해당하는 댓글 리스트 가져오기")
	@GetMapping("/managercommentlist")
	public ResponseEntity<List<ManagerComment>> managerCommentList(String managerId){
		List<ManagerComment> managerCommentList = mService.getManagerCommentList(managerId);
		return new ResponseEntity<List<ManagerComment>>(managerCommentList,HttpStatus.OK);		
	}
	
	// 관리자 댓글 수정
	@ApiOperation(value = "관리자 댓글 수정", notes = "댓글 아이디에 맞는 관리자 댓글 하나 수정")
	@PutMapping("/managercomment/update")
	public ResponseEntity<Void> managerCommentUpdate(@RequestBody ManagerComment managerComment){		
		mService.updateManagerComment(managerComment);		
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	// 댓글 아이디에 맞는 관리자 댓글 하나 삭제
	@ApiOperation(value = "관리자 댓글 삭제", notes = "댓글 아이디에 맞는 관리자 댓글 하나 삭제")
	@PutMapping("/managercomment/{id}")
	public ResponseEntity<Void> managerCommentRemove(@PathVariable int id){
		mService.removeManagerComment(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/**
	 * 
	 */
	
	// 공지사항 등록
	@ApiOperation(value = "공지사항 등록")
	@PostMapping("/managerNotice")
	public ResponseEntity<ManagerNotice> managerNoticeWrite(@RequestBody ManagerNotice managerNotice){
		mService.writeManagerNotice(managerNotice);
		return new ResponseEntity<ManagerNotice>(managerNotice, HttpStatus.OK);		
	}
	
	// 공지사항 전체 리스트
	@ApiOperation(value = "공지사항 전체 리스트", notes = "얘는 삭제된 공지사항은 안 뜸")
	@GetMapping("/managerNoticeList")
	public ResponseEntity<List<ManagerNotice>> managerNoticeList(){
		List<ManagerNotice> managerNoticeList = mService.getManagerNoticeList();
		return new ResponseEntity<List<ManagerNotice>>(managerNoticeList,HttpStatus.OK);		
	}
	
	// 이벤트 전체 리스트
	@ApiOperation(value = "이벤트 전체 리스트", notes = "얘는 삭제된 이벤트는 안 뜸")
	@GetMapping("/managerEventList")
	public ResponseEntity<List<ManagerNotice>> managerEventList(){
		List<ManagerNotice> managerEventList = mService.getManagerEventList();
		return new ResponseEntity<List<ManagerNotice>>(managerEventList,HttpStatus.OK);		
	}
	
	// 관리자 마다의 공지사항 리스트
	@ApiOperation(value = "관리자 마다의 공지사항 리스트", notes = "얘는 삭제된 공지사항도 뜨고, 공지사항이랑 이벤트 같이 보여줌")
	@GetMapping("/managerNotice")
	public ResponseEntity<List<ManagerNotice>> managerNotice(String managerId){
		List<ManagerNotice> managerNoticeList = mService.getManagerNotice(managerId);
		return new ResponseEntity<List<ManagerNotice>>(managerNoticeList,HttpStatus.OK);		
	}
	
	// 공지사항 수정
	@ApiOperation(value = "공지사항 수정", notes = "공지사항/이벤트 아이디에 맞는 공지사항 수정")
	@PutMapping("/managerNotice/update")
	public ResponseEntity<Void> managerNoticeUpdate(@RequestBody ManagerNotice managerNotice){		
		mService.updateManagerNotice(managerNotice);		
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	// 공지사항 삭제
	@ApiOperation(value = "공지사항 삭제", notes = "공지사항/이벤트 아이디에 맞는 공지사항 삭제")
	@PutMapping("/managerNotice/{id}")
	public ResponseEntity<Void> managerNoticeRemove(@PathVariable int id){
		mService.removeManagerNotice(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 공지사항 상세조회
	@ApiOperation(value = "공지사항 상세조회", notes = "공지사항/이벤트 아이디에 해당하는 글 상세조회")
	@GetMapping("/managerNotice/{id}")
	public ResponseEntity<ManagerNotice> managerNoticeDetail(@PathVariable int id) {
		ManagerNotice managerNotice = mService.getOneManagerNotice(id);
		return new ResponseEntity<ManagerNotice>(managerNotice, HttpStatus.OK);		
	}
	
	
	
}
