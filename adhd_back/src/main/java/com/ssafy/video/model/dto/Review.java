package com.ssafy.video.model.dto;

import java.util.Date;

public class Review {
	
	private int reviewId;
	private int productId;
	private String userId;
	private String type;
	private String reviewTitle;
	private String reviewDate;
	private String reviewContent;
	private int reviewStar;
	private String reviewDelete;
	
	public Review() {
	}

	public Review(int reviewId, int productId, String userId, String type, String reviewTitle, String reviewDate,
			String reviewContent, int reviewStar, String reviewDelete) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.userId = userId;
		this.type = type;
		this.reviewTitle = reviewTitle;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.reviewStar = reviewStar;
		this.reviewDelete = reviewDelete;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getReviewDelete() {
		return reviewDelete;
	}

	public void setReviewDelete(String reviewDelete) {
		this.reviewDelete = reviewDelete;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", productId=" + productId + ", userId=" + userId + ", type=" + type
				+ ", reviewTitle=" + reviewTitle + ", reviewDate=" + reviewDate + ", reviewContent=" + reviewContent
				+ ", reviewStar=" + reviewStar + ", reviewDelete=" + reviewDelete + "]";
	}
	
	

}
