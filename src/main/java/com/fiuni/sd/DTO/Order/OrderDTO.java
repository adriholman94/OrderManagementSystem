package com.fiuni.sd.DTO.Order;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
@XmlRootElement
public class OrderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Date orderDate;
	private String clientRuc;
	private Integer finalPrice;
	private Boolean isCanceled;
	@XmlElement
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@XmlElement
	public String getClientRuc() {
		return clientRuc;
	}

	public void setClientRuc(String clientRuc) {
		this.clientRuc = clientRuc;
	}
	@XmlElement
	public Integer getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}
	@XmlElement
	public Boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

}
