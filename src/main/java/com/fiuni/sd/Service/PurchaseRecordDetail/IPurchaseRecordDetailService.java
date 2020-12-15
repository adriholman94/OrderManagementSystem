package com.fiuni.sd.Service.PurchaseRecordDetail;

import com.fiuni.sd.Service.Base.IBaseService;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailDTO;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailResult;

public interface IPurchaseRecordDetailService extends IBaseService<PurchaseRecordDetailDTO, PurchaseRecordDetailResult> {

	PurchaseRecordDetailDTO getById(Integer Id);
}

