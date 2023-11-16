package com.ssafy.video.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.VideoDao;
import com.ssafy.video.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	private static VideoService service = new VideoServiceImpl();

	
	//의존성 주입
	@Autowired
	private VideoDao dao;
	
	
	private VideoServiceImpl() {
	}
	
	public static VideoService getInstance() {
		return service;
	}
	
	
	@Override
	public List<Video> getList() {
		return dao.selectAll();
	}
	
	@Override
	public List<Video> getPartList(String fitPartName) {
		return dao.selectPart(fitPartName);
	}

	@Override
	public Video getOne(String id) {
		dao.updateViewCnt(id);
		return dao.selectOne(id);
	}

//	@Override
//	public Video getVideo(String fitPartName) {
//		return dao.selectPart(video);
//	}


	
}
