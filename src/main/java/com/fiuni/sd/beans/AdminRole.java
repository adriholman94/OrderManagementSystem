package com.fiuni.sd.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "AdminRoles")
public class AdminRole implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roleId", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "roleName", unique = true)
	private String roleName;
	
	@ManyToMany(mappedBy = "AdminRole")
	private Set<Admin> admins;
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return roleName;
	}
	
	public Set<Admin> getAdmins() {
		return admins;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String roleName) {
		this.roleName = roleName;
	}
	
	public void setUsers(Set<Admin> admins) {
		this.admins = admins;
	}
	
	@Override
	public String toString() {
		return "AdminRole [roleId=" + id + ", roleName=" + roleName + ", admins=" + admins + "]";
	}
}
