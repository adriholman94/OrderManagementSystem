package com.fiuni.sd.DTO.ProductSupplier;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fiuni.sd.DTO.Base.BaseResult;

//producto por proveedor

public class ProductSupplierResult extends BaseResult<ProductSupplierDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ProductSupplierDTO> getProductSuppliers() {
		return getList();
	}

	public void setProductSupplier(List<ProductSupplierDTO> dtos) {
		super.setList(dtos);
	}
}
