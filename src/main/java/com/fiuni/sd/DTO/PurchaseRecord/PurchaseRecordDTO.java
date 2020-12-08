package com.fiuni.sd.DTO.PurchaseRecord;

import java.util.Date;

import com.fiuni.sd.DTO.Base.BaseDTO;


//registro de compras

public class PurchaseRecordDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private Date date;
	private Integer finalPrice;
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}



}
