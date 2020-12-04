package com.fiuni.sd.DTO;



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
