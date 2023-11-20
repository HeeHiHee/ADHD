package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Manager;

public interface ManagerService {
	
	// 관리자 리스트 조회
	List<Manager> getManagerList();
	
	// 관리자 등록
	void writeManager(Manager manager);
	
	// 관리자 수정
	void updateManager(Manager manager);
	
	// 관리자 삭제
	void removeManager(String id);

}
