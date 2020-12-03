package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Id;

//producto por proveedor
@Entity
@Table(name = "ProductsSupplier")
public class ProductsSupplier implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productSupplierId", nullable = false, unique = true)
	private Integer productSupplierId;

	@ManyToOne
	@JoinColumn(name = "suppilerId")
	private Supplier supplier;

	@OneToOne(mappedBy = "productsSupplier")
	private Product products;

	@OneToOne
	private PurchaseRecordDetail purchaseRecordDetail;

	public Supplier get_suppliers() {
		return supplier;
	}

	public void set_suppliers(Supplier suppliers) {
		this.supplier = suppliers;
	}

	public Integer getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(Integer productSupplierId) {
		this.productSupplierId = productSupplierId;
	}

	public String toString() {
		return "productSupplier [id=" + productSupplierId + ", suppliers=" + supplier + ", products=" + products
				+ ", purchaseRecordDetail=" + purchaseRecordDetail + "]";
	}

}
