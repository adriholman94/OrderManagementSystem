package com.fiuni.sd.Service.Supplier;

import com.fiuni.sd.DTO.Supplier.SupplierDTO;
import com.fiuni.sd.DTO.Supplier.SupplierResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface ISupplierService extends IBaseService<SupplierDTO, SupplierResult> {

	SupplierDTO getById(Integer roleId);

	SupplierResult getSuppliers();
}
