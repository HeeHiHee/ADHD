package com.ssafy.video.model.dto;

public class ManagerComment {
	
	private int commentId;
	private String managerId;
	private int reviewId;
	private String commentContent;
	private String commentDate;
	private String commentDelete;
	
	public ManagerComment() {
	}

	public ManagerComment(int commentId, String managerId, int reviewId, String commentContent, String commentDate,
			String commentDelete) {
		super();
		this.commentId = commentId;
		this.managerId = managerId;
		this.reviewId = reviewId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentDelete = commentDelete;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentDelete() {
		return commentDelete;
	}

	public void setCommentDelete(String commentDelete) {
		this.commentDelete = commentDelete;
	}

	@Override
	public String toString() {
		return "ManagerComment [commentId=" + commentId + ", managerId=" + managerId + ", reviewId=" + reviewId
				+ ", commentContent=" + commentContent + ", commentDate=" + commentDate + ", commentDelete="
				+ commentDelete + "]";
	}
	
	
}
