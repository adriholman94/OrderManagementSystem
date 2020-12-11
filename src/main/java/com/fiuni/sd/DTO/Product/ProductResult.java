package com.fiuni.sd.DTO.Product;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;

@XmlRootElement(name = "productResult")
public class ProductResult extends BaseResult<ProductDTO> {

	private static final long serialVersionUID = 1L;
	@XmlElement
	public List<ProductDTO> getProducts() {
		return list();
	}

	public void setProduct(List<ProductDTO> dtos) {
		super.setList(dtos);
	}
}
