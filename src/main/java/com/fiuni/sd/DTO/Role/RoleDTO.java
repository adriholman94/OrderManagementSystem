package com.fiuni.sd.DTO.Role;

import com.fiuni.sd.DTO.Base.BaseDTO;

public class RoleDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
