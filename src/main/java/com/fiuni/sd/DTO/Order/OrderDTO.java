package com.fiuni.sd.DTO.Order;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.OrderDetails.OrderDetailDTO;

@XmlRootElement
public class OrderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Date orderDate;
	private String clientRuc;
	private Integer finalPrice;
	private Boolean isCanceled;

	private List<OrderDetailDTO> orderDetail;
	@XmlElement
	public List<OrderDetailDTO> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetailDTO> orderDetail) {
		this.orderDetail = orderDetail;
	}

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
