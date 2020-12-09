package com.fiuni.sd.DTO.Role;

import java.util.List;

import com.fiuni.sd.DTO.Base.BaseResult;

public class RoleResult extends BaseResult<RoleDTO> {

	private static final long serialVersionUID = 1L;

	public List<RoleDTO> getRoles() {
		return getList();
	}

	public void setRoles(List<RoleDTO> dtos) {
		super.setList(dtos);
	}

}