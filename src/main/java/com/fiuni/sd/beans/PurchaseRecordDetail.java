package com.fiuni.sd.beans;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

//registr de compra detalle
@Entity
@Table(name = "purchaseRecordDetail")
public class PurchaseRecordDetail implements BaseBeans {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer purchaseRecordDetailId;

	@ManyToOne
	private PurchaseRecords _purchaseRecords;

	@OneToOne
	private ProductsSupplier _productsSupplier;

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

	public PurchaseRecords get_purchaseRecords() {
		return _purchaseRecords;
	}

	public void set_purchaseRecords(PurchaseRecords _purchaseRecords) {
		this._purchaseRecords = _purchaseRecords;
	}

	public ProductsSupplier get_productsSupplier() {
		return _productsSupplier;
	}

	public void set_productsSupplier(ProductsSupplier _productsSupplier) {
		this._productsSupplier = _productsSupplier;
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
		return "purchaseRecordDetail[id=" + purchaseRecordDetailId + ", _purchaseRecords=" + _purchaseRecords
				+ ", _productsSupplier=" + _productsSupplier + ", _productsSupplier=" + _productsSupplier
				+ ", productQuantity =" + productQuantity + ", unitPrice =" + unitPrice + ", _productOrderDetail ="
				+ totalPrice + "]";
	}
}
