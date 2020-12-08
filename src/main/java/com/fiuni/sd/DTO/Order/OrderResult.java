package com.fiuni.sd.DTO.Order;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.DTO.Base.BaseResult;

public class OrderResult extends BaseResult<OrderDTO> {

	private static final long serialVersionUID = 1L;

	public List<OrderDTO> getOrders() {
		return getList();
	}

	public void setOrder(List<OrderDTO> dtos) {
		super.setList(dtos);
	}
}