package com.fiuni.sd.DTO.Supplier;

import com.fiuni.sd.DTO.Base.BaseDTO;

//proveedores

public class SupplierDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	private String supplierName;


}
