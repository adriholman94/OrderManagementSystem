package com.fiuni.sd.DTO.OrderDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
@XmlRootElement
public class OrderDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Integer productId;
	private Integer productQuantity;
	private Integer quantityPrice;

	private Integer orderDetailId;
	@XmlElement
	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	@XmlElement
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
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
	@XmlElement
	public Integer getQuantityPrice() {
		return quantityPrice;
	}

	public void setQuantityPrice(Integer quantityPrice) {
		this.quantityPrice = quantityPrice;
	}

}
