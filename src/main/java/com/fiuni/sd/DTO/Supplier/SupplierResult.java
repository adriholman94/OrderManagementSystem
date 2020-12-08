package com.fiuni.sd.DTO.Supplier;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.DTO.Base.BaseResult;

//proveedores

public class SupplierResult extends BaseResult<SupplierDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<SupplierDTO> getSuppliers() {
		return getList();
	}

	public void setSupplier(List<SupplierDTO> dtos) {
		super.setList(dtos);
	}
}
