package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.ManagerDao;
import com.ssafy.video.model.dto.Manager;

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
	

}
