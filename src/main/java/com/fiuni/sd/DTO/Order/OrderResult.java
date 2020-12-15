package com.fiuni.sd.DTO.Order;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;
@XmlRootElement(name = "orderResult")
public class OrderResult extends BaseResult<OrderDTO> {

	private static final long serialVersionUID = 1L;
	@XmlElement
	public List<OrderDTO> getOrders() {
		return list();
	}

	public void setOrder(List<OrderDTO> dtos) {
		super.setList(dtos);
	}
}