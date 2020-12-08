package com.fiuni.sd.Service.Role;


import com.fiuni.sd.DTO.Role.RoleDTO;
import com.fiuni.sd.DTO.Role.RoleResult;
import com.fiuni.sd.Service.Base.IBaseService;
import com.fiuni.sd.beans.Role.Role;

public interface IRoleService extends IBaseService<Role, RoleDTO,   RoleResult> {

	RoleDTO getById(Integer roleId);
	
}
