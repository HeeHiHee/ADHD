package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Video;


public interface VideoService {
	
		// 게시글 전체 조회
		List<Video> getList();



		List<Video> getPartList(String fitPartName);
		
		Video getOne(String id);

}
