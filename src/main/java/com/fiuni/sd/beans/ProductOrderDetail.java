package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "productOrderDetail")
public class ProductOrderDetail {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer	productOrderDetailId;
	
	@Column(name = "orderDetailId")
	private Integer	orderDetailId;
	
	@Column(name = "orderId")
	private Integer	orderId;
	
	@Column(name = "productId")
	private Integer	productId;
	
	@Column(name = "productQuantity")
	private Integer	productQuantity;
	
	@Column(name = "quantityPrice")
	private Integer	quantityPrice;
	
	public Integer getProductOrderDetailId() {
		return productOrderDetailId;
	}
	public void setProductOrderDetailId(Integer productOrderDetailId) {
		this.productOrderDetailId = productOrderDetailId;
	}
	public Integer getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Integer getQuantityPrice() {
		return quantityPrice;
	}
	public void setQuantityPrice(Integer quantityPrice) {
		this.quantityPrice = quantityPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
