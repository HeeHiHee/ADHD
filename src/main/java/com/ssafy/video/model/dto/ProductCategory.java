package com.ssafy.video.model.dto;

public class ProductCategory {
	private int categoryId;
	private String categoryName;
	private int level;
	private int parentCategoryId;
	
	public ProductCategory() {
	}

	public ProductCategory(int categoryId, String categoryName, int level, int parentCategoryId) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.level = level;
		this.parentCategoryId = parentCategoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", level=" + level
				+ ", parentCategoryId=" + parentCategoryId + "]";
	}
	
	
	
}
