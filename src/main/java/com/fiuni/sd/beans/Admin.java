package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
@Entity
@Table(name = "admin")
public class Admin implements BaseBeans{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer	adminId;
	
	@ManyToOne
	private Users	_user;

	@ManyToOne
	private Roles	_role;
	
	public Users get_user() {
		return _user;
	}
	public void set_user(Users _user) {
		this._user = _user;
	}
	public Roles get_role() {
		return _role;
	}
	public void set_role(Roles _role) {
		this._role = _role;
	}

	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String toString() {
		return "Admin [id=" + adminId + ", user=" + _user + ", role=" + _role + "]";
	}

}
