package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

//producto por proveedor
@Entity
@Table(name = "productsSupplier")
public class ProductsSupplier {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer	productSupplierId;
	
	@Column(name = "supplierId")
	private Integer	supplierId;
	
	@Column(name = "productId")
	private Integer	productId;
	
	

public Integer getProductSupplierId() {
	return productSupplierId;
}
public void setProductSupplierId(Integer productSupplierId) {
	this.productSupplierId = productSupplierId;
}
public Integer getSupplierId() {
	return supplierId;
}
public void setSupplierId(Integer supplierId) {
	this.supplierId = supplierId;
}
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}


}
