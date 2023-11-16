package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.User;

public interface UserService {

//	public abstract List<User> getUserList(); //아래와 동일
	List<User> getUserList();

	int signup(User user);

	User login(User user);
	
	List<User> getSelectList(String id);
	
}