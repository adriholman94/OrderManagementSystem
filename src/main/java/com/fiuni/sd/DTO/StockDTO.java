package com.fiuni.sd.DTO;

import java.io.Serializable;


public class StockDTO implements Serializable{
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
