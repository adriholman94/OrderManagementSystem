package com.fiuni.sd.DTO;




public class StockDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private Integer productQuantity;

	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

}
