package com.fiuni.sd.DTO;


//producto por proveedor

public class ProductSupplierDTO extends BaseDTO{
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
