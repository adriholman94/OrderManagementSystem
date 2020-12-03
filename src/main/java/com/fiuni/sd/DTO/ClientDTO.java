package com.fiuni.sd.DTO;

import java.io.Serializable;



public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String clientRuc; 
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getClientRuc() {
		return clientRuc;
	}
	public void setClientRuc(String clientRuc) {
		this.clientRuc = clientRuc;
	}

}
