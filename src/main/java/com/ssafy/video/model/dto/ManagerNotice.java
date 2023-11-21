package com.ssafy.video.model.dto;

public class ManagerNotice {
	
	private int noticeId;
	private String managerId;
	private String noticeType;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWriter;
	private String noticeImg;
	private int noticeViews;
	private String noticeDate;
	private String noticeDelete;
	
	public ManagerNotice() {
	}

	public ManagerNotice(int noticeId, String managerId, String noticeType, String noticeTitle, String noticeContent,
			String noticeWriter, String noticeImg, int noticeViews, String noticeDate, String noticeDelete) {
		super();
		this.noticeId = noticeId;
		this.managerId = managerId;
		this.noticeType = noticeType;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.noticeImg = noticeImg;
		this.noticeViews = noticeViews;
		this.noticeDate = noticeDate;
		this.noticeDelete = noticeDelete;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeImg() {
		return noticeImg;
	}

	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
	}

	public int getNoticeViews() {
		return noticeViews;
	}

	public void setNoticeViews(int noticeViews) {
		this.noticeViews = noticeViews;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeDelete() {
		return noticeDelete;
	}

	public void setNoticeDelete(String noticeDelete) {
		this.noticeDelete = noticeDelete;
	}

	@Override
	public String toString() {
		return "ManagerNotice [noticeId=" + noticeId + ", managerId=" + managerId + ", noticeType=" + noticeType
				+ ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", noticeWriter=" + noticeWriter
				+ ", noticeImg=" + noticeImg + ", noticeViews=" + noticeViews + ", noticeDate=" + noticeDate
				+ ", noticeDelete=" + noticeDelete + "]";
	}
	
	
}
