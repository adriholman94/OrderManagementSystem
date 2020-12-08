package com.fiuni.sd.Beans.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.Product.Product;
import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecordDetail;

import javax.persistence.Id;

//producto por proveedor
@Entity
@Table(name = "ProductsSupplier")
public class ProductsSupplier implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_Supplier_Id", nullable = false, unique = true)
	private Integer productSupplierId;

	@ManyToOne
	@JoinColumn(name = "suppiler_Id")
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
