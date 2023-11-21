package com.ssafy.video.model.dto;

public class Product {

	private int productId;
	private int categoryId;
	private String productName;
	private int cost;
	private int price;
	private int profit;
	private String productImg;
	private String productInfoImg;
	private boolean soldOut;
	private String regDate;
	private int orderCnt;
	private String productDelete;
	private int productType;
	private String registId;
	
	public Product() {
	}
	
	public Product(int productId, int categoryId, String productName, int cost, int price, int profit,
			String productImg, String productInfoImg, boolean soldOut, String regDate, int orderCnt, String productDelete, int productType, String registId) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.cost = cost;
		this.price = price;
		this.profit = profit;
		this.productImg = productImg;
		this.productInfoImg = productInfoImg;
		this.soldOut = soldOut;
		this.regDate = regDate;
		this.orderCnt = orderCnt;
		this.productDelete = productDelete;
		this.productType = productType;
		this.registId = registId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductInfoImg() {
		return productInfoImg;
	}

	public void setProductInfoImg(String productInfoImg) {
		this.productInfoImg = productInfoImg;
	}

	public boolean isSoldOut() {
		return soldOut;
	}

	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getOrderCnt() {
		return orderCnt;
	}

	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}

	public String getProductDelete() {
		return productDelete;
	}

	public void setProductDelete(String productDelete) {
		this.productDelete = productDelete;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public String getRegistId() {
		return registId;
	}

	public void setRegistId(String registId) {
		this.registId = registId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", cost=" + cost + ", price=" + price + ", profit=" + profit + ", productImg=" + productImg
				+ ", productInfoImg=" + productInfoImg + ", soldOut=" + soldOut + ", regDate=" + regDate + ", orderCnt="
				+ orderCnt + ", productDelete=" + productDelete + ", productType=" + productType + ", registId="
				+ registId + "]";
	}
	

}
