package com.fiuni.sd.DTO.Supplier;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;

//proveedores
@XmlRootElement
public class SupplierDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	
	private String supplierName;
	
	@XmlElement
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	


}
