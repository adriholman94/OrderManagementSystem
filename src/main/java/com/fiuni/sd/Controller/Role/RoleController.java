package com.fiuni.sd.Controller.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import javax.validation.Valid;

import com.fiuni.sd.Beans.Role.Role;
import com.fiuni.sd.Beans.User.User;
import com.fiuni.sd.DTO.Role.RoleDTO;
import com.fiuni.sd.DTO.Role.RoleResult;
import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.Service.Role.IRoleService;

//import com.fiuni.sd.tienda.utils.Setting;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	@GetMapping(path = "/{id}", produces = {"application/xml", "application/json"})
	public RoleDTO getById(@PathVariable(value = "id") Integer roleId) {
		return roleService.getById(roleId);
	}

	@GetMapping(path = "/page/{page_num}", produces = {"application/xml", "application/json"})
	public RoleResult getRols(@PathVariable(value = "page_num") Integer pageNum) {
		return roleService.getAll(PageRequest.of(pageNum, 3));
	}

	@PostMapping()
	public RoleDTO save(@Valid @RequestBody RoleDTO client) {
		return roleService.save(client);
	}

	@PutMapping(path ="/{id}")
	public RoleDTO update(@PathVariable(value = "id") Integer roleId,@Valid @RequestBody RoleDTO role) {
		return roleService.update(role,roleId);
	}
	@DeleteMapping(path ="/{id}")
	public Optional<Role> delete(@PathVariable int id) {
		return roleService.deleteById(id);
	}
}
