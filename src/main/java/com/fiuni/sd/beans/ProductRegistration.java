package com.fiuni.sd.beans;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "productRegistration")
public class ProductRegistration {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer productRegistrationId;
	
	@Column(name = "productPurchaseId")
	private Integer	productPurchaseId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "finalPrice")
	private Integer	finalPrice;



public Integer getProductPurchaseId() {
	return productPurchaseId;
}
public void setProductPurchaseIdId(Integer productPurchaseId) {
	this.productPurchaseId = productPurchaseId;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Integer getFinalPrice() {
	return finalPrice;
}
public void setFinalPrice(Integer finalPrice) {
	this.finalPrice = finalPrice;
}


}
