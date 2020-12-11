package com.fiuni.sd.DTO.PurchaseRecord;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;


//registro de compras
@XmlRootElement
public class PurchaseRecordDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private Date date;
	private Integer finalPrice;
	@XmlElement
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@XmlElement
	public Integer getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}
}
