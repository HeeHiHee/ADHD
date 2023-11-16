package com.ssafy.video.model.dto;

public class Video implements Comparable<Video>{
	
	private String id;
	private String title;
	private String fitPartName;
	private String channel_name;
	private String url;
	private int viewCnt;
	


	public Video() {
		
	}

	public Video(String id, String title, String fitPartName, String channelName, String url) {
		this.id = id;
		this.title = title;
		this.fitPartName = fitPartName;
		this.channel_name = channelName;
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getfitPartName() {
		return fitPartName;
	}

	public void setfitPartName(String fitPartName) {
		this.fitPartName = fitPartName;
	}

	public String getChannelName() {
		return channel_name;
	}

	public void setChannelName(String channelName) {
		this.channel_name = channelName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public int compareTo(Video o) {
		return this.viewCnt-o.viewCnt;
	}

}
