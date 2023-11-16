package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.UserDao;
import com.ssafy.video.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	// 회원가입
	@Override
	public void signup(User user) {
		userDao.signup(user);
	}

	// 로그인
	@Override
	public User login(User user) {
		//DB 해당 ID만 넘겨서 데이터를 가지고 오고 가지고온 User 데이터와 내가 현재 가지고 있는 user의 비밀번호를 확인하면
		User tmp = userDao.getUserOne(user.getUserId());
		//tmp가 실제 User 정보 일수도 있고 / null 넘어왔다.
		if(tmp != null && tmp.getUserPw().equals(user.getUserPw()))
			return tmp;
		return null;
	}

	// 유저 한 명 조회
	@Override
	public User getUserOne(String id) {
		return userDao.getUserOne(id);
	}

}
