package com.fiuni.sd.DTO;



import java.io.Serializable;

public class AdminRoleDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer roleId;
	private String roleName;

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
