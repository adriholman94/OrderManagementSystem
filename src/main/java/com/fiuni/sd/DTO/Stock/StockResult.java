package com.fiuni.sd.DTO.Stock;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.DTO.Base.BaseResult;

public class StockResult extends BaseResult<StockDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<StockDTO> getStocks() {
		return getList();
	}

	public void setStock(List<StockDTO> dtos) {
		super.setList(dtos);
	}
}
