package com.ssafy.video.model.dto;

public class User {
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userNickname;
	private boolean manager; // true이면 1, false이면 0
	private String userStatus; // Y, B, C
	
	public User() {
	}

	public User(String userId, String userPw, String userName, String userPhone, String userEmail, String userNickname,
			boolean manager, String userStatus) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userNickname = userNickname;
		this.manager = manager;
		this.userStatus = userStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}	
	

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userPhone=" + userPhone
				+ ", userEmail=" + userEmail + ", userNickname=" + userNickname + ", manager=" + manager
				+ ", userStatus=" + userStatus + "]";
	}

	
	
	
	
}
