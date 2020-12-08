package com.fiuni.sd.Beans.PurchaseRecord;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.Supplier.ProductsSupplier;

import javax.persistence.Id;

//registr de compra detalle
@Entity
@Table(name = "PurchaseRecordDetails")
public class PurchaseRecordDetail implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_Record_Detail_Id", nullable = false, unique = true)
	private Integer purchaseRecordDetailId;

	@ManyToOne
	@JoinColumn(name = "purchase_Record_Id")
	private PurchaseRecord purchaseRecord;

	@OneToOne
	@JoinColumn(name = "product_Supplier_id")
	private ProductsSupplier productsSupplier;

	@Column(name = "productQuantity")
	private Integer productQuantity;

	@Column(name = "unitPrice")
	private Integer unitPrice;

	@Column(name = "totalPrice")
	private Integer totalPrice;

	public Integer getPurchaseRecordDetailId() {
		return purchaseRecordDetailId;
	}

	public void setPurchaseRecordDetailId(Integer purchaseRecordDetailId) {
		this.purchaseRecordDetailId = purchaseRecordDetailId;
	}

	public PurchaseRecord get_purchaseRecords() {
		return purchaseRecord;
	}

	public void set_purchaseRecords(PurchaseRecord purchaseRecords) {
		this.purchaseRecord = purchaseRecords;
	}

	public ProductsSupplier get_productsSupplier() {
		return productsSupplier;
	}

	public void set_productsSupplier(ProductsSupplier productsSupplier) {
		this.productsSupplier = productsSupplier;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String toString() {
		return "purchaseRecordDetail[id=" + purchaseRecordDetailId + ", purchaseRecords=" + purchaseRecord
				+ ", productsSupplier=" + productsSupplier + ", productsSupplier=" + productsSupplier
				+ ", productQuantity =" + productQuantity + ", unitPrice =" + unitPrice + ", orderDetail ="
				+ totalPrice + "]";
	}
}
