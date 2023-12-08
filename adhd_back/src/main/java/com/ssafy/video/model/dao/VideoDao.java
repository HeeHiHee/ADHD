package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.Video;

public interface VideoDao {
	List<Video> selectAll();
	

	List<Video> selectPart(String fitPartName);
	
	void updateViewCnt(String id);
	
	Video selectOne(String id);


}
