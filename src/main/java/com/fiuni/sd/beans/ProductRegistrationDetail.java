package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
@Entity
@Table(name = "productRegistrationDetail")
public class ProductRegistrationDetail {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer	productRegistrationDetailId;
	
	@Column(name = "productRegistrationId")
	private Integer	productRegistrationId;
	
	@Column(name = "productsSupplierId")
	private Integer	productsSupplierId;
	
	@Column(name = "productQuantity")
	private Integer	productQuantity;
	
	@Column(name = "unitPrice")
	private Integer	unitPrice;
	
	@Column(name = "totalPrice")
	private Integer	totalPrice;


public Integer getProductRegistrationDetailId() {
	return productRegistrationDetailId;
}
public void setProductRegistrationDetailId(Integer productRegistrationDetailId) {
	this.productRegistrationDetailId = productRegistrationDetailId;
}
public Integer getProductRegistrationId() {
	return productRegistrationId;
}
public void setProductRegistrationId(Integer productRegistrationId) {
	this.productRegistrationId = productRegistrationId;
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
