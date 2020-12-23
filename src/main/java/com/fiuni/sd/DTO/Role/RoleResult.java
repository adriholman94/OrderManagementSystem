package com.fiuni.sd.DTO.Role;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;

@XmlRootElement
public class RoleResult extends BaseResult<RoleDTO> {

	private static final long serialVersionUID = 1L;
	private Integer pages;
	@XmlElement
	public List<RoleDTO> getRoles() {
		return list();
	}

	public void setRoles(List<RoleDTO> dtos) {
		super.setList(dtos);
	}
	public Integer getPages() {
		return this.pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}
}