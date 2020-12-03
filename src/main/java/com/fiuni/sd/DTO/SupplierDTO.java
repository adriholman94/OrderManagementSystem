package com.fiuni.sd.DTO;

import java.io.Serializable;

//proveedores

public class SupplierDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	private String supplierName;


}
