package com.ssafy.video.model.dto;

import java.util.Date;

public class Review {
	private String videoid;
	private int reviewid;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int viewCnt;
	
	public Review() {}
	
	public Review(String videoid, String title, String writer, String content) {
		this.videoid=videoid;
		this.title=title;
		this.writer=writer;
		this.content=content;
	}

	public String getVideoid() {
		return videoid;
	}

	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}

	public int getReviewid() {
		return reviewid;
	}

	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	
	
	

}
