package com.fiuni.sd.DTO;

import java.io.Serializable;
import java.util.Date;


public class ProductOrderDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Date orderDate;
	private String clientRuc;
	private Integer finalPrice;
	private Boolean isCanceled;
	
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getClientRuc() {
		return clientRuc;
	}
	public void setClientRuc(String clientRuc) {
		this.clientRuc = clientRuc;
	}
	public Integer getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}
	public Boolean getIsCanceled() {
		return isCanceled;
	}
	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}



}
