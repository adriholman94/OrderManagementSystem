package com.fiuni.sd.DTO.Role;

import java.util.List;

import com.fiuni.sd.DTO.Base.BaseResult;




//@XmlRootElement(name = "rolResult")
public class RoleResult extends BaseResult<RoleDTO> {

	private static final long serialVersionUID = 1L;

	//@XmlElement
	public List<RoleDTO> getRoles() {
		return getList();
	}

	public void setRoles(List<RoleDTO> dtos) {
		super.setList(dtos);
	}

	
	
}