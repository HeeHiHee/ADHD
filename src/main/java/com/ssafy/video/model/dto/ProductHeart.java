package com.ssafy.video.model.dto;

public class ProductHeart {
	private int heartId;
	private String userId;
	private int productId;
	
	public ProductHeart() {
	}

	public ProductHeart(int heartId, String userId, int productId) {
		super();
		this.heartId = heartId;
		this.userId = userId;
		this.productId = productId;
	}

	public int getHeartId() {
		return heartId;
	}

	public void setHeartId(int heartId) {
		this.heartId = heartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductHeart [heartId=" + heartId + ", userId=" + userId + ", productId=" + productId + "]";
	}
	
	

}
