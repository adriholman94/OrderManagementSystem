package com.fiuni.sd.DTO.PurchaseRecord;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailDTO;

//registro de compras
@XmlRootElement
public class PurchaseRecordDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private Date date;
	private Integer finalPrice;
	private List<PurchaseRecordDetailDTO> details;
	
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

	@XmlElement
	public List<PurchaseRecordDetailDTO> getRoles() {
		return details;
	}

	public void setRoles(List<PurchaseRecordDetailDTO> details) {
		this.details = details;
	}
}
