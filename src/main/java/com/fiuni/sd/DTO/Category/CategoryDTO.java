package com.fiuni.sd.DTO.Category;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;

@XmlRootElement(name = "categories")
public class CategoryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private String categoryName;

	@XmlElement
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
