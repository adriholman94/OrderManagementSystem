package com.fiuni.sd.DTO.Supplier;

import java.util.List;

import com.fiuni.sd.DTO.Base.BaseResult;

//proveedores

public class SupplierResult extends BaseResult<SupplierDTO> {

	private static final long serialVersionUID = 1L;

	public List<SupplierDTO> getSuppliers() {
		return list();
	}

	public void setSupplier(List<SupplierDTO> dtos) {
		super.setList(dtos);
	}
}
