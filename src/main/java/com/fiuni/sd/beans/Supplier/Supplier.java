package com.fiuni.sd.Beans.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecordDetail;

import javax.persistence.Id;

//proveedores
@Entity
@Table(name = "Suppliers")
public class Supplier implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_Id", nullable = false, unique = true)
	private Integer supplierId;

	@Column(name = "supplier_Name")
	private String supplierName;

	@OneToOne
	private PurchaseRecordDetail purchaseRecordDetails;

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String toString() {
		return "suppliers[id=" + supplierId + ", supplierName=" + supplierName + "]";
	}
}
