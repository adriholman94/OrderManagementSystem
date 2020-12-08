package com.fiuni.sd.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.DTO.RoleResult;
import com.fiuni.sd.DTO.UserDTO;
import com.fiuni.sd.DTO.UserResult;
import com.fiuni.sd.Service.IUserService;


@RestController
@RequestMapping("/users")
public class UsuarioResource {

	@Autowired
	private IUserService userService;
	//@Autowired
	//private Setting setting;

	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable(value = "id") Integer userId) {
		return userService.getById(userId);
	}

	@GetMapping(path = "/page/{page_num}")
	public UserResult getUsers(@PathVariable(value = "page_num")Integer pageNum) {
		return userService.getAll(PageRequest.of(pageNum,3));
	}

	@PostMapping()
	public UserDTO save(@Valid @RequestBody UserDTO client) {
		return userService.save(client);
	}
}
