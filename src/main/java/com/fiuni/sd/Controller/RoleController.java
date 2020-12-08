package com.fiuni.sd.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.DTO.RoleDTO;
import com.fiuni.sd.DTO.RoleResult;
import com.fiuni.sd.DTO.UserDTO;
import com.fiuni.sd.Service.IRoleService;



//import com.fiuni.sd.tienda.utils.Setting;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	


	@GetMapping("/{id}")
	public RoleDTO getById(@PathVariable(value = "id") Integer roleId) {
		return roleService.getById(roleId);
	}
	
	@GetMapping(path = "/page/{page_num}")
	public RoleResult getRols(@PathVariable(value = "page_num")Integer pageNum) {
		return roleService.getAll(PageRequest.of(pageNum,3));
	}
}
