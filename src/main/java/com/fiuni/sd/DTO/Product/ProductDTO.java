package com.fiuni.sd.DTO.Product;

import com.fiuni.sd.DTO.Base.BaseDTO;

public class ProductDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private String productName;
	private Integer productPrice;
	private Integer categoryId;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
