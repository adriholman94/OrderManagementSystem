package com.fiuni.sd.DTO.OrderDetails;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;
@XmlRootElement(name = "orderDetailResult")
public class OrderDetailResult extends BaseResult<OrderDetailDTO> {

	private static final long serialVersionUID = 1L;
	@XmlElement
	public List<OrderDetailDTO> getProductOrderDetails() {
		return list();
	}

	public void setProductOrderDetail(List<OrderDetailDTO> dtos) {
		super.setList(dtos);
	}
}