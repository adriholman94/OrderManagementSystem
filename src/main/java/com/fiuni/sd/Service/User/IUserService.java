package com.fiuni.sd.Service.User;

import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.DTO.User.UserResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface IUserService extends IBaseService<UserDTO,UserResult> {
	UserDTO getById(Integer userId);
	UserDTO deleteById(Integer Id);
	UserDTO findByUserName(String username);
	 UserResult getUsers() ;
}
