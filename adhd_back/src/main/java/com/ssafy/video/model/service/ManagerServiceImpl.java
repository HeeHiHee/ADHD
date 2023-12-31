package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.ManagerDao;
import com.ssafy.video.model.dto.Manager;
import com.ssafy.video.model.dto.ManagerComment;
import com.ssafy.video.model.dto.ManagerNotice;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerDao dao;
	
	// 관리자 리스트 조회
	@Override
	public List<Manager> getManagerList() {
		return dao.getManagerList();
	}
	
	// 관리자 등록
	@Override
	public void writeManager(Manager manager) {
		dao.writeManager(manager);
	}
	
	// 관리자 수정
	@Override
	public void updateManager(Manager manager) {
		dao.updateManager(manager);
		
	}
	
	// 관리자 삭제
	@Override
	public void removeManager(String id) {
		dao.removeManager(id);
	}
	
	
	
	
	
	
	// 관리자 댓글 등록
	@Override
	public void writeManagerComment(ManagerComment managerComment) {
		dao.writeManagerComment(managerComment);		
	}
	
	// 관리자 아이디에 해당하는 댓글 리스트 가져오기
	@Override
	public List<ManagerComment> getManagerCommentList(String managerId) {
		return dao.getManagerCommentList(managerId);
	}
	
	// 댓글 아이디에 맞는 관리자 댓글 리스트 조회
	@Override
	public List<ManagerComment> getManagerCommentIdList(int reviewId) {
		return dao.getManagerCommentIdList(reviewId);
	}
	
	// 관리자 댓글 수정
	@Override
	public void updateManagerComment(ManagerComment managerComment) {
		dao.updateManagerComment(managerComment);		
	}
	
	// 댓글 아이디에 맞는 관리자 댓글 하나 삭제
	@Override
	public void removeManagerComment(int id) {
		dao.removeManagerComment(id);
		
	}

	
	
	// 공지사항 등록
	@Override
	public void writeManagerNotice(ManagerNotice managerNotice) {
		dao.writeManagerNotice(managerNotice);
		
	}
	
	// 공지사항 전체 리스트
	@Override
	public List<ManagerNotice> getManagerNoticeList() {
		return dao.getManagerNoticeList();
	}
	
	// 이벤트 전체 리스트
	@Override
	public List<ManagerNotice> getManagerEventList() {
		return dao.getManagerEventList();
	}	

	// 관리자 마다의 공지사항 리스트
	@Override
	public List<ManagerNotice> getManagerNotice(String managerId) {
		return dao.getManagerNotice(managerId);
	}
	
	// 공지사항 수정
	@Override
	public void updateManagerNotice(ManagerNotice managerNotice) {
		dao.updateManagerNotice(managerNotice);
	}

	// 공지사항 삭제
	@Override
	public void removeManagerNotice(int id) {
		dao.removeManagerNotice(id);
		
	}
	
	// 공지사항 상세
	@Override
	public ManagerNotice getOneManagerNotice(int id) {
		dao.updateViewCnt(id);
		return dao.getOneManagerNotice(id);
	}

	

}
