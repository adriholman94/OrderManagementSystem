package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
@Entity
@Table(name = "users")
public class Users {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer userId;
	
	@Column(name = "userName")
	private	String userName;
	
	@Transient
	private	String userPassword; 
	
	@Column(name = "firstName")
	private	String firstName;
	
	@Column(name = "lastName")
	private	String lastName;
	
	@Column(name = "userPhone")
	private	String userPhone;
	
	@Column(name = "userMail")
	private	String userMail;
	
	@OneToMany(mappedBy="_user")
	private Set<Clients>_clients= new HashSet<>();
	
	@OneToMany(mappedBy="_user")
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
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String toString() {
		return "user[id=" +userId + ", userName=" + userName + ", userPassword=" + userPassword 
				+ ", firstName=" + firstName +", lastName =" + lastName 
				+", userPhone =" + userPhone +", userMail =" + userMail +", _clients =" +_clients +", _admin =" +_admin+ "]";
	}

}
