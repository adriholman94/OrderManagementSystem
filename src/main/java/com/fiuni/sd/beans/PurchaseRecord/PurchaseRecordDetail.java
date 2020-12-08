package com.fiuni.sd.Beans.PurchaseRecord;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.Product.Product;
import com.fiuni.sd.Beans.Supplier.Supplier;

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

	@Column(name = "productQuantity")
	private Integer productQuantity;

	@Column(name = "unitPrice")
	private Integer unitPrice;

	@Column(name = "totalPrice")
	private Integer totalPrice;

	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;

	@OneToOne
	@JoinColumn(name = "suppliertId")
	private Supplier supplier;

	public Integer getPurchaseRecordDetailId() {
		return purchaseRecordDetailId;
	}

	public void setPurchaseRecordDetailId(Integer purchaseRecordDetailId) {
		this.purchaseRecordDetailId = purchaseRecordDetailId;
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
				+ ", productQuantity =" + productQuantity + ", unitPrice =" + unitPrice + ", totalPrice =" + totalPrice
				+ "]";
	}

	public PurchaseRecord getPurchaseRecord() {
		return purchaseRecord;
	}

	public void setPurchaseRecord(PurchaseRecord purchaseRecord) {
		this.purchaseRecord = purchaseRecord;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
