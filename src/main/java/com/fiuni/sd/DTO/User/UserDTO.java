package com.fiuni.sd.DTO.User;

import com.fiuni.sd.DTO.Base.BaseDTO;

public class UserDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	

	private String userName;
	private String userPassword; 

	private String userMail;


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

}
