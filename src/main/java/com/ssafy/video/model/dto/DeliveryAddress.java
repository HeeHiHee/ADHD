package com.ssafy.video.model.dto;

public class DeliveryAddress {
	private int deliveryAddressId;
	private String userId;
	private String deliveryName;
	private String receiverName;
	private String receiverPhone;
	private String additionalPhone;
	private String deliveryAddress1;
	private String deliveryAddress2;
	private String deliveryMemo;
	
	public DeliveryAddress() {
	}

	public DeliveryAddress(int deliveryAddressId, String userId, String deliveryName, String receiverName,
			String receiverPhone, String additionalPhone, String deliveryAddress1, String deliveryAddress2,
			String deliveryMemo) {
		super();
		this.deliveryAddressId = deliveryAddressId;
		this.userId = userId;
		this.deliveryName = deliveryName;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.additionalPhone = additionalPhone;
		this.deliveryAddress1 = deliveryAddress1;
		this.deliveryAddress2 = deliveryAddress2;
		this.deliveryMemo = deliveryMemo;
	}

	public int getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(int deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
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

	public String getAdditionalPhone() {
		return additionalPhone;
	}

	public void setAdditionalPhone(String additionalPhone) {
		this.additionalPhone = additionalPhone;
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
		return "ProductDeliveryAddress [deliveryAddressId=" + deliveryAddressId + ", userId=" + userId
				+ ", deliveryName=" + deliveryName + ", receiverName=" + receiverName + ", receiverPhone="
				+ receiverPhone + ", additionalPhone=" + additionalPhone + ", deliveryAddress1=" + deliveryAddress1
				+ ", deliveryAddress2=" + deliveryAddress2 + ", deliveryMemo=" + deliveryMemo + "]";
	}
	
	
	

}
