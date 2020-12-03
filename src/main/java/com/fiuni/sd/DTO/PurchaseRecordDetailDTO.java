package com.fiuni.sd.DTO;

import java.io.Serializable;

//registr de compra detalle

public class PurchaseRecordDetailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer purchaseRecordId;
	private Integer productsSupplierId;
	private Integer productQuantity;
	private Integer unitPrice;
	private Integer totalPrice;
	
	
	public Integer getPurchaseRecordId() {
		return purchaseRecordId;
	}
	public void setPurchaseRecordId(Integer purchaseRecordId) {
		this.purchaseRecordId = purchaseRecordId;
	}
	public Integer getProductsSupplierId() {
		return productsSupplierId;
	}
	public void setProductsSupplierId(Integer productsSupplierId) {
		this.productsSupplierId = productsSupplierId;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}



}
