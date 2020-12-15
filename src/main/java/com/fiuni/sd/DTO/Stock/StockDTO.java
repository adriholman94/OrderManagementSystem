package com.fiuni.sd.DTO.Stock;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
@XmlRootElement
public class StockDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private Integer productQuantity;

	@XmlElement
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	@XmlElement
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

}
