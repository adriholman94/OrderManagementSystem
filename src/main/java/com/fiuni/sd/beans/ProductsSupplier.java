package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

//producto por proveedor
@Entity
@Table(name = "productsSupplier")
public class ProductsSupplier implements BaseBean {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer productSupplierId;

	@ManyToOne
	private Supplier _suppliers;

	@OneToOne
	private Product _products;

	@OneToOne
	private PurchaseRecordDetail _purchaseRecordDetail;

	public Supplier get_suppliers() {
		return _suppliers;
	}

	public void set_suppliers(Supplier _suppliers) {
		this._suppliers = _suppliers;
	}

	public Integer getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(Integer productSupplierId) {
		this.productSupplierId = productSupplierId;
	}

	public String toString() {
		return "productSupplier [id=" + productSupplierId + ", _suppliers=" + _suppliers + ",_products=" + _products
				+ ", _purchaseRecordDetail=" + _purchaseRecordDetail + "]";
	}

}
