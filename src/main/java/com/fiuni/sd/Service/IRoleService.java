package com.fiuni.sd.Service;


import com.fiuni.sd.DTO.RoleDTO;
import com.fiuni.sd.DTO.RoleResult;
import com.fiuni.sd.beans.Role;

public interface IRoleService extends IBaseService<Role, RoleDTO,   RoleResult> {

	RoleDTO getById(Integer roleId);
	
}
