package com.fiuni.sd.DTO.Category;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;

@XmlRootElement
public class CategoryResult extends BaseResult<CategoryDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<CategoryDTO> getCategories() {
		return list();
	}

	public void setCategory(List<CategoryDTO> dtos) {
		super.setList(dtos);
	}
}