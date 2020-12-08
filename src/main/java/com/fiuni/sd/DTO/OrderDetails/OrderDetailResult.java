package com.fiuni.sd.DTO.OrderDetails;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.DTO.Base.BaseResult;




public class OrderDetailResult extends BaseResult<OrderDetailDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<OrderDetailDTO> getProductOrderDetails() {
		return getList();
	}

	public void setProductOrderDetail(List<OrderDetailDTO> dtos) {
		super.setList(dtos);
	}}