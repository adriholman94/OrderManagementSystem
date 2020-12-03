package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Id;

//proveedores
@Entity
@Table(name = "Suppliers")
public class Supplier implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "supplierId", nullable = false, unique = true)
	private Integer supplierId;

	@Column(name = "supplierName")
	private String supplierName;

	@OneToMany(mappedBy = "supplier")
	private Set<ProductsSupplier> productsSuppliers = new HashSet<>();

	public Set<ProductsSupplier> get_productsSuppliers() {
		return productsSuppliers;
	}

	public void set_productsSuppliers(Set<ProductsSupplier> productsSuppliers) {
		this.productsSuppliers = productsSuppliers;
	}

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
		return "suppliers[id=" + supplierId + ", supplierName=" + supplierName + ", productsSuppliers="
				+ productsSuppliers + ", productsSuppliers=" + productsSuppliers + "]";
	}
}
