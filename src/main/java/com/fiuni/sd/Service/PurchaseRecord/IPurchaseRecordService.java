package com.fiuni.sd.Service.PurchaseRecord;

import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordDTO;
import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface IPurchaseRecordService extends IBaseService<PurchaseRecordDTO, PurchaseRecordResult> {

	PurchaseRecordDTO getById(Integer Id);
}
