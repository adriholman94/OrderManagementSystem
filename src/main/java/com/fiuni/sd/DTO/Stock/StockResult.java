package com.fiuni.sd.DTO.Stock;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;
@XmlRootElement(name = "stockResult")
public class StockResult extends BaseResult<StockDTO> {

	private static final long serialVersionUID = 1L;
	@XmlElement
	public List<StockDTO> getStocks() {
		return list();
	}

	public void setStock(List<StockDTO> dtos) {
		super.setList(dtos);
	}
}
