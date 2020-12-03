package com.fiuni.sd.DTO;

import java.io.Serializable;

//producto por proveedor

public class ProductSupplierDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer supplierId;
	private Integer productId;
	
	
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
