package com.fiuni.sd.beans;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
 
import org.springframework.data.annotation.Id;

//registr de compra detalle
@Entity
@Table(name = "purchaseRecordDetail")
public class PurchaseRecordDetail {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer	purchaseRecordDetailId;
	
	
	@Column(name = "purchaseRecordId")
	private Integer	purchaseRecordId;
	
	@Column(name = "productsSupplierId")
	private Integer	productsSupplierId;
	
	@Column(name = "productQuantity")
	private Integer	productQuantity;
	
	@Column(name = "unitPrice")
	private Integer	unitPrice;
	
	@Column(name = "totalPrice")
	private Integer	totalPrice;


	public Integer getPurchaseRecordDetailId() {
		return purchaseRecordDetailId;
	}
	public void setPurchaseRecordDetailId(Integer purchaseRecordDetailId) {
		this.purchaseRecordDetailId = purchaseRecordDetailId;
	}
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
