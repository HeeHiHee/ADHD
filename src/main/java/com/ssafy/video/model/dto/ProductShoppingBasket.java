package com.ssafy.video.model.dto;

public class ProductShoppingBasket {
	private int productShoppingBasketId;
	private String userId;
	private int productId;
	private String productSize;
	private String productOption;
	private int productCnt;
	private String productDetail;
	
	public ProductShoppingBasket() {
	}

	
	public ProductShoppingBasket(int productShoppingBasketId, String userId, int productId, String productSize,
			String productOption, int productCnt, String productDetail) {
		super();
		this.productShoppingBasketId = productShoppingBasketId;
		this.userId = userId;
		this.productId = productId;
		this.productSize = productSize;
		this.productOption = productOption;
		this.productCnt = productCnt;
		this.productDetail = productDetail;
	}


	public int getProductShoppingBasketId() {
		return productShoppingBasketId;
	}

	public void setProductShoppingBasketId(int productShoppingBasketId) {
		this.productShoppingBasketId = productShoppingBasketId;
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

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductOption() {
		return productOption;
	}

	public void setProductOption(String productOption) {
		this.productOption = productOption;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}	

	public String getProductDetail() {
		return productDetail;
	}


	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}


	@Override
	public String toString() {
		return "ProductShoppingBasket [productShoppingBasketId=" + productShoppingBasketId + ", userId=" + userId
				+ ", productId=" + productId + ", productSize=" + productSize + ", productOption=" + productOption
				+ ", productCnt=" + productCnt + ", productDetail=" + productDetail + "]";
	}


	

}
