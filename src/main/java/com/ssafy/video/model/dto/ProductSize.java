package com.ssafy.video.model.dto;

public class ProductSize {
	
	private int productSizeId;
	private int productId;
	private String productSize;
	
	public ProductSize() {
	}

	public ProductSize(int productSizeId, int productId, String productSize) {
		super();
		this.productSizeId = productSizeId;
		this.productId = productId;
		this.productSize = productSize;
	}

	public int getProductSizeId() {
		return productSizeId;
	}

	public void setProductSizeId(int productSizeId) {
		this.productSizeId = productSizeId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	@Override
	public String toString() {
		return "ProductSize [productSizeId=" + productSizeId + ", productId=" + productId + ", productSize="
				+ productSize + "]";
	}
	

}
