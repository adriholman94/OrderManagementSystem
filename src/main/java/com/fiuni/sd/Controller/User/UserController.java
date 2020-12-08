package com.fiuni.sd.Controller.User;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.DTO.Role.RoleResult;
import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.DTO.User.UserResult;
import com.fiuni.sd.Service.User.IUserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

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
