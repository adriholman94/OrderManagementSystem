package com.fiuni.sd.DTO.Stock;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Product.ProductDTO;
@XmlRootElement
public class StockDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private ProductDTO product;
	private Integer productQuantity;
	
	@XmlElement
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	@XmlElement
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	

}
