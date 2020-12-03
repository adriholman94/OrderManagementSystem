package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Clients")
public class Client implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clientId", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "clientRuc")
	private String clientRuc;
	
	@Column(name = "userPhone")
	private String clientPhone;
	
	@OneToOne
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
	
	public void setDocId(String RUC) {
		this.clientRuc = RUC;
	}
	
	public void setPhone(String phone) {
		this.clientPhone = phone;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setEmail(String email) { this.email = email; }

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + firstName + ", lastName=" + lastName + ", clientRuc=" + clientRuc + ", clientPhone=" + clientPhone + ", user=" + user + "]";
	}
}
