package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Users")
public class User implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userMail")
	private String email;	
		
	@Column(name = "userPassword")
	private String password;

	@OneToOne(mappedBy = "User")
	private Admin admin;

	@OneToOne(mappedBy = "User")
	private Client client;
	
	public Integer getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setEmail(String email) {
		this. email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + id + ", userName=" + userName + ", userMail=" + email + ", userPassword=" + password + "]";
	}

}