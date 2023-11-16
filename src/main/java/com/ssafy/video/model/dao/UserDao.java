package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.User;

public interface UserDao {
	
	List<User> selectAll();
	
	List<User> selectList(String id);
	
	int insertUser(User user);
	
	User selectOne(User user);
}
