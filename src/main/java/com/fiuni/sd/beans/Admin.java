package com.fiuni.sd.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "admin")
public class Admin implements BaseBean {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "adminId", nullable = false, unique = true)
	private Integer adminId;

	@ManyToOne
	private User _user;

	@ManyToMany(mappedBy = "AdminRoles")
	private Set<AdminRole> adminRoles;

	public User get_user() {
		return _user;
	}

	public void set_user(User _user) {
		this._user = _user;
	}

	public Set<AdminRole> get_roles() {
		return adminRoles;
	}

	public void set_roles(Set<AdminRole> roles) {
		this.adminRoles = roles;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String toString() {
		return "Admin [adminId=" + adminId + ", user=" + _user + ", AdminRoles=" + adminRoles + "]";
	}

}
