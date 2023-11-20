package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.Manager;
import com.ssafy.video.model.dto.ManagerComment;

public interface ManagerDao {
	
	// 관리자 리스트 조회
	List<Manager> getManagerList();
	
	// 관리자 등록
	void writeManager(Manager manager);
	
	// 관리자 수정
	void updateManager(Manager manager);
	
	// 관리자 삭제
	void removeManager(String id);
	
	// 관리자 댓글 관리//////////////////////////////////////////////////
	
	// 관리자 댓글 등록
	void writeManagerComment(ManagerComment managerComment);
	
	// 관리자 아이디에 해당하는 댓글 리스트 가져오기
	 List<ManagerComment> getManagerCommentList(String managerId);
	 
	// 관리자 댓글 수정
	 void updateManagerComment(ManagerComment managerComment);
	 
	// 댓글 아이디에 맞는 관리자 댓글 하나 삭제
	 void removeManagerComment(int id);
	
}
