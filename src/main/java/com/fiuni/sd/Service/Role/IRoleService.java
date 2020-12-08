package com.fiuni.sd.Service.Role;


import com.fiuni.sd.Beans.Role.Role;
import com.fiuni.sd.DTO.Role.RoleDTO;
import com.fiuni.sd.DTO.Role.RoleResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface IRoleService extends IBaseService<Role, RoleDTO,   RoleResult> {

	RoleDTO getById(Integer roleId);
	
}
