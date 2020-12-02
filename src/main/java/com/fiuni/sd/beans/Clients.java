package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "clients")
public class Clients {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer clientId; 
	
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "clientRuc")
	private Integer clientRuc; 
	

	@ManyToOne
	private Roles _role;
	
	@OneToMany(mappedBy="_clients")
	private Set<ProductOrder>_productOrders= new HashSet<>();
	
	
	public Set<ProductOrder> get_productOrders() {
		return _productOrders;
	}
	public void set_productOrders(Set<ProductOrder> _productOrders) {
		this._productOrders = _productOrders;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getClientRuc() {
		return clientRuc;
	}
	public void setClientRuc(Integer clientRuc) {
		this.clientRuc = clientRuc;
	}

	public Roles get_role() {
		return _role;
	}
	public void set_role(Roles _role) {
		this._role = _role;
	}
}
