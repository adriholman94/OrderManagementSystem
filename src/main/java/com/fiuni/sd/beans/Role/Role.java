package com.fiuni.sd.Beans.Role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.User.User;

@Entity(name = "Roles")
public class Role implements BaseBean {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id", nullable = false, unique = true)
	private int roleId;

	@Column(name = "role_Name")
	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + roleId + ", name=" + roleName + ", users=" + users + "]";
	}
}
