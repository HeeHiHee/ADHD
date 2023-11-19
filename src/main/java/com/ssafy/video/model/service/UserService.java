package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.User;

public interface UserService {
	
	// 회원가입
	void signup(User user);
	
	// 로그인
	User login(User user);
	
	// 유저 한 명 조회
	User getUserOne(String id);
	
	// 유저 정보 수정
	void updateUser(User user);
	
	// 유저 정보 삭제
	void UserRemove(String id);
	
}