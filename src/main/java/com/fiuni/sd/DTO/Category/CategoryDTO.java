package com.fiuni.sd.DTO.Category;

import com.fiuni.sd.DTO.Base.BaseDTO;

public class CategoryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
