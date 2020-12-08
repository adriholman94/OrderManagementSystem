package com.fiuni.sd.DTO.PurchaseRecordDetails;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.DTO.Base.BaseResult;

//registr de compra detalle

public class PurchaseRecordDetailResult extends BaseResult<PurchaseRecordDetailDTO> {

	private static final long serialVersionUID = 1L;

	public List<PurchaseRecordDetailDTO> getPurchaseRecordDetails() {
		return getList();
	}

	public void setPurchaseRecordDetail(List<PurchaseRecordDetailDTO> dtos) {
		super.setList(dtos);
	}
}
