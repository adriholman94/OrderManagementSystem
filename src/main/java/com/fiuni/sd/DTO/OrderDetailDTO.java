package com.fiuni.sd.DTO;

import java.io.Serializable;




public class OrderDetailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Integer productId;
	private Integer productQuantity;
	private Integer quantityPrice;

	
	private Integer orderDetailId;
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
	
}
