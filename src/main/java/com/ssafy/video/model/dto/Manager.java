package com.ssafy.video.model.dto;

public class Manager {
	
	private String managerId;
	private String managerPw;
	private String managerName;
	private String managerDelete;
	
	public Manager() {
	}

	public Manager(String managerId, String managerPw, String managerName, String managerDelete) {
		super();
		this.managerId = managerId;
		this.managerPw = managerPw;
		this.managerName = managerName;
		this.managerDelete = managerDelete;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPw() {
		return managerPw;
	}

	public void setManagerPw(String managerPw) {
		this.managerPw = managerPw;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerDelete() {
		return managerDelete;
	}

	public void setManagerDelete(String managerDelete) {
		this.managerDelete = managerDelete;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerPw=" + managerPw + ", managerName=" + managerName
				+ ", managerDelete=" + managerDelete + "]";
	}


	
}
