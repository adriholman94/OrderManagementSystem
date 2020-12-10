package com.fiuni.sd.DTO.User;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Role.RoleDTO;

@XmlRootElement(name = "users")
public class UserDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String userPassword;
	private String userMail;
	private List<RoleDTO> roles;

	@XmlElement
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@XmlElement
	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@XmlElement
	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "ClientDTO [userName=" + userName + ", email=" + userMail + "password=" + userPassword + "]";
	}

}
