package com.fiuni.sd.DTO;





public class ClientDTO extends BaseDTO{
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
