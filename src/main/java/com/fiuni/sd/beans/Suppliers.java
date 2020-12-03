package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

//proveedores
@Entity
@Table(name = "suppliers")
public class Suppliers implements BaseBeans{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer	supplierId;
	
	@Column(name = "supplierName")
	private String	supplierName;
	
	@OneToMany(mappedBy="_suppliers")
	private Set<ProductsSupplier>_productsSuppliers= new HashSet<>();
	
	public Set<ProductsSupplier> get_productsSuppliers() {
		return _productsSuppliers;
	}
	public void set_productsSuppliers(Set<ProductsSupplier> _productsSuppliers) {
		this._productsSuppliers = _productsSuppliers;
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
		return "suppliers[id=" + supplierId + ", supplierName=" +supplierName + 
				", _productsSuppliers=" + _productsSuppliers 
				+ ", _productsSuppliers=" + _productsSuppliers +"]";
	}
}
