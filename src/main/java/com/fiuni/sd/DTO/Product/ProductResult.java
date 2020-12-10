package com.fiuni.sd.DTO.Product;

import java.util.List;

import com.fiuni.sd.DTO.Base.BaseResult;

public class ProductResult extends BaseResult<ProductDTO> {

	private static final long serialVersionUID = 1L;

	public List<ProductDTO> getProducts() {
		return list();
	}

	public void setProduct(List<ProductDTO> dtos) {
		super.setList(dtos);
	}
}
