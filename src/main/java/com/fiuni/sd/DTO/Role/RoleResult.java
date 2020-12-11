package com.fiuni.sd.DTO.Role;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;

@XmlRootElement(name = "roleResult")
public class RoleResult extends BaseResult<RoleDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<RoleDTO> getRoles() {
		return list();
	}

	public void setRoles(List<RoleDTO> dtos) {
		super.setList(dtos);
	}

}