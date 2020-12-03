package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "Admins")
public class Admin implements BaseBean {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "adminId", nullable = false, unique = true)
	private Integer adminId;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToMany
    @JoinTable
    private Set<AdminRole> adminRoles;

	public User get_user() {
		return user;
	}

	public void set_user(User _user) {
		this.user = _user;
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
		return "Admin [adminId=" + adminId + ", user=" + user + ", AdminRoles=" + adminRoles + "]";
	}

}
