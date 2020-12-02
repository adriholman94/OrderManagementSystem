package com.fiuni.sd.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
@Entity
@Table(name = "productOrder")
public class ProductOrder {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer productOrderId;
	@Column(name = "orderId")
	private Integer orderId;
	
	@Column(name = "orderDate")
	private Date orderDate;
	
	@Column(name = "clientId")
	private Integer clientId;
	
	@Column(name = "finalPrice")
	private Integer finalPrice;
	
	@Column(name = "isCanceled")
	private Boolean isCanceled;
	
	
	public Integer getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(Integer productOrderId) {
		this.productOrderId = productOrderId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
