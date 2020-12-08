package com.fiuni.sd.DTO;

import java.util.List;




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