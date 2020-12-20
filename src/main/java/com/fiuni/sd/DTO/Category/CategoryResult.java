package com.fiuni.sd.DTO.Category;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;

@XmlRootElement(name = "categoryResult")
public class CategoryResult extends BaseResult<CategoryDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<CategoryDTO> getCategories() {
		return list();
	}

	public void setCategories(List<CategoryDTO> dtos) {
		super.setList(dtos);
	}
	
	private Integer pages;

	public Integer getPages() {
		return this.pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
}