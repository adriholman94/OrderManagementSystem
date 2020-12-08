package com.fiuni.sd.DTO.Category;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.DTO.Base.BaseResult;

public class CategoryResult extends BaseResult<CategoryDTO> {

	private static final long serialVersionUID = 1L;

	public List<CategoryDTO> getCategories() {
		return getList();
	}

	public void setCategory(List<CategoryDTO> dtos) {
		super.setList(dtos);
	}
}