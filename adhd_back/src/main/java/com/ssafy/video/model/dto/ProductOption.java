package com.ssafy.video.model.dto;

public class ProductOption {
	
	private int productOptionId;
	private int productId;
	private String productOption;
	
	public ProductOption() {
	}

	public ProductOption(int productOptionId, int productId, String productOption) {
		super();
		this.productOptionId = productOptionId;
		this.productId = productId;
		this.productOption = productOption;
	}

	public int getProductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(int productOptionId) {
		this.productOptionId = productOptionId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductOption() {
		return productOption;
	}

	public void setProductOption(String productOption) {
		this.productOption = productOption;
	}

	@Override
	public String toString() {
		return "ProductOption [productOptionId=" + productOptionId + ", productId=" + productId + ", productOption="
				+ productOption + "]";
	}
	

}
