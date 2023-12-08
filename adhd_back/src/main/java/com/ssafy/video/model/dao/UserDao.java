package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.User;

public interface UserDao {
	
	// 유저 한 명 조회
	User getUserOne(String id);
	
	// 유저 닉네임 조회
	User getUserNick(String nick);
	
	// 회원가입
	void signup(User user);
	
	// 유저 정보 수정
	void updateUser(User user);
	
	// 유저 탈퇴
	void UserCancel(String id);
	
	// 유저 탈퇴
	void UserBan(String id);

}
