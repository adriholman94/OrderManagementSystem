package com.fiuni.sd.DTO.User;

import java.util.List;

import com.fiuni.sd.DTO.Base.BaseResult;

public class UserResult extends BaseResult<UserDTO> {

	private static final long serialVersionUID = 1L;

	public List<UserDTO> getUsers() {
		return getList();
	}

	public void setUsers(List<UserDTO> dtos) {
		super.setList(dtos);
	}
}