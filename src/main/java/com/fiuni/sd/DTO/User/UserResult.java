package com.fiuni.sd.DTO.User;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;


@XmlRootElement(name = "userResult")
public class UserResult extends BaseResult<UserDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<UserDTO> getUsers() {
		return list();
	}

	public void setUsers(List<UserDTO> dtos) {
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