package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.User;

public interface UserDao {
	
	// 유저 한 명 조회
	User getUserOne(String id);
	
	// 회원가입
	void signup(User user);
	
	// 유저 정보 수정
	void updateUser(User user);

}
