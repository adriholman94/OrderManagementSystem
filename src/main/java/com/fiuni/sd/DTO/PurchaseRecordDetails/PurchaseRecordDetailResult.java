package com.fiuni.sd.DTO.PurchaseRecordDetails;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;

//registr de compra detalle
@XmlRootElement(name = "purchaseRecordDetailResult")
public class PurchaseRecordDetailResult extends BaseResult<PurchaseRecordDetailDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<PurchaseRecordDetailDTO> getPurchaseRecordDetails() {
		return list();
	}

	public void setPurchaseRecordDetail(List<PurchaseRecordDetailDTO> dtos) {
		super.setList(dtos);
	}
}
