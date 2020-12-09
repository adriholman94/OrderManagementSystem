package com.fiuni.sd.DTO.PurchaseRecord;

import java.util.List;

import com.fiuni.sd.DTO.Base.BaseResult;


//registro de compras

public class PurchaseRecordResult extends BaseResult<PurchaseRecordDTO> {

	private static final long serialVersionUID = 1L;

	public List<PurchaseRecordDTO> getPurchaseRecords() {
		return getList();
	}

	public void setPurchaseRecord(List<PurchaseRecordDTO> dtos) {
		super.setList(dtos);
	}
}
