package com.fiuni.sd.DTO;

import java.io.Serializable;


public class CategoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String categoryName;

	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
