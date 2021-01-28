package com.fiuni.sd.Controller.User;


import javax.validation.Valid;

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

import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.DTO.User.UserResult;
import com.fiuni.sd.Service.User.IUserService;
import com.fiuni.sd.Utils.Setting;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private Setting setting;

	@Autowired
	private IUserService userService;

	@GetMapping(path = "/{id}", produces = { "application/xml", "application/json" })
	public UserDTO getById(@PathVariable(value = "id") Integer userId) {
		return userService.getById(userId);
	}

	@GetMapping(path = "/page/{page_num}", produces = { "application/xml", "application/json" })
	public UserResult getUsers(@PathVariable(value = "page_num") Integer pageNum) {
		return userService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
	}

	@PostMapping(produces = { "application/xml", "application/json" })
	public UserDTO save(@Valid @RequestBody UserDTO client) {
		return userService.save(client);
	}

	@PutMapping(path ="/{id}", produces = {"application/xml", "application/json"})
	public UserDTO update(@PathVariable final Integer id, @RequestBody final UserDTO role) {
		return userService.update(role, id);
	}

	@DeleteMapping(path ="/{id}", produces = {"application/xml", "application/json"})
	public UserDTO delete(@PathVariable int id) {
		return userService.deleteById(id);
	}

	@GetMapping(path = "/search/{user_name}", produces = {"application/xml", "application/json"})
	public UserDTO findByUserName(@PathVariable(value = "user_name")String userName) {
		return userService.findByUserName(userName);
	}
}
