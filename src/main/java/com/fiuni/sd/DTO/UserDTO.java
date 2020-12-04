package com.fiuni.sd.DTO;

import java.io.Serializable;


public class UserDTO implements Serializable{
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
