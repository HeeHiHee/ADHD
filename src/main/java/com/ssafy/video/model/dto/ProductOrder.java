package com.ssafy.video.model.dto;

public class ProductOrder {
	private int orderId;
	private String userId;
	private int productId;
	private int productPrice;
	private String productSize;
	private String productOption;
	private String productDetailOption;
	private int productCnt;
	private String orderDate;
	private String receiverName;
	private String receiverPhone;
	private String deliveryAddress1;
	private String deliveryAddress2;
	private String deliveryMemo;
	
	public ProductOrder() {
	}

	public ProductOrder(int orderId, String userId, int productId, int productPrice, String productSize, String productOption,
			String productDetailOption, int productCnt, String orderDate, String receiverName, String receiverPhone,
			String deliveryAddress1, String deliveryAddress2, String deliveryMemo) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.productPrice = productPrice;
		this.productSize = productSize;
		this.productOption = productOption;
		this.productDetailOption = productDetailOption;
		this.productCnt = productCnt;
		this.orderDate = orderDate;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.deliveryAddress1 = deliveryAddress1;
		this.deliveryAddress2 = deliveryAddress2;
		this.deliveryMemo = deliveryMemo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
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

	public String getProductDetailOption() {
		return productDetailOption;
	}

	public void setProductDetailOption(String productDetailOption) {
		this.productDetailOption = productDetailOption;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getDeliveryAddress1() {
		return deliveryAddress1;
	}

	public void setDeliveryAddress1(String deliveryAddress1) {
		this.deliveryAddress1 = deliveryAddress1;
	}

	public String getDeliveryAddress2() {
		return deliveryAddress2;
	}

	public void setDeliveryAddress2(String deliveryAddress2) {
		this.deliveryAddress2 = deliveryAddress2;
	}

	public String getDeliveryMemo() {
		return deliveryMemo;
	}

	public void setDeliveryMemo(String deliveryMemo) {
		this.deliveryMemo = deliveryMemo;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", productPrice="
				+ productPrice + ", productSize=" + productSize + ", productOption=" + productOption
				+ ", productDetailOption=" + productDetailOption + ", productCnt=" + productCnt + ", orderDate="
				+ orderDate + ", receiverName=" + receiverName + ", receiverPhone=" + receiverPhone
				+ ", deliveryAddress1=" + deliveryAddress1 + ", deliveryAddress2=" + deliveryAddress2
				+ ", deliveryMemo=" + deliveryMemo + "]";
	}
	
	
}
