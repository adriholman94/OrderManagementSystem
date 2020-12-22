package com.fiuni.sd.DTO.PurchaseRecord;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;

//registro de compras
@XmlRootElement(name = "purchaseRecordResult")
public class PurchaseRecordResult extends BaseResult<PurchaseRecordDTO> {

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<PurchaseRecordDTO> getPurchaseRecords() {
		return list();
	}

	public void setPurchaseRecord(List<PurchaseRecordDTO> dtos) {
		super.setList(dtos);
	}

	private Integer pages;

	public Integer getPages() {
		return this.pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

}
