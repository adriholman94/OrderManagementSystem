package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
@Entity

public class Roles {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer roleId;
	
	@Column(name = "roleName")
	private String roleName;
	

	@OneToMany(mappedBy="_role")
	private Set<Clients>_clients= new HashSet<>();
	
	@OneToMany(mappedBy="_role")
	private Set<Admin>_admin= new HashSet<>();
	
	
	public Set<Clients> get_clients() {
		return _clients;
	}
	public void set_clients(Set<Clients> _clients) {
		this._clients = _clients;
	}
	public Set<Admin> get_admin() {
		return _admin;
	}
	public void set_admin(Set<Admin> _admin) {
		this._admin = _admin;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}
