package com.fiuni.sd.DTO;

import java.util.Date;


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
