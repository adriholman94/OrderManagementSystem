package com.fiuni.sd.Beans.User;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.Role.Role;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "Users")
public class User implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_Id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "user_Name")
	private String userName;

	@Column(name = "user_Mail")
	private String email;

	@Column(name = "user_Password")
	private String password;

	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Integer getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserMail() {
		return email;
	}

	public String getUserPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserMail(String email) {
		this.email = email;
	}

	public void setUserPassword(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	@Override
	public String toString() {
		return "Users [userId=" + id + ", userName=" + userName + ", userMail=" + email + ", userPassword=" + password
				+ ", roles=" + roles + "]";
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}