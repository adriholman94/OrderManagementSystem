package com.fiuni.sd.beans.Client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fiuni.sd.beans.Base.BaseBean;
import com.fiuni.sd.beans.User.User;

import javax.persistence.Id;

@Entity
@Table(name = "Clients")
public class Client implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_Id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "first_Name")
	private String firstName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "client_Ruc")
	private String clientRuc;

	@Column(name = "client_Phone")
	private String clientPhone;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRUC() {
		return clientRuc;
	}

	public String getPhone() {
		return clientPhone;
	}

	public User getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String fristName) {
		this.firstName = fristName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRUC(String RUC) {
		this.clientRuc = RUC;
	}

	public void setPhone(String phone) {
		this.clientPhone = phone;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + firstName + ", lastName=" + lastName + ", clientRuc=" + clientRuc
				+ ", clientPhone=" + clientPhone + ", user=" + user + "]";
	}
}
