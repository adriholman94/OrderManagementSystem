package com.fiuni.sd.DTO.PurchaseRecordDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordDTO;
import com.fiuni.sd.DTO.Supplier.SupplierDTO;

//registr de compra detalle
@XmlRootElement
public class PurchaseRecordDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private PurchaseRecordDTO purchaseRecord;
	private SupplierDTO supplier;
	private ProductDTO product;
	private Integer productQuantity;
	private Integer unitPrice;
	private Integer totalPrice;

	@XmlElement
	public PurchaseRecordDTO getPurchaseRecord() {
		return purchaseRecord;
	}

	public void setPurchaseRecord(PurchaseRecordDTO purchaseRecord) {
		this.purchaseRecord = purchaseRecord;
	}

	@XmlElement
	public SupplierDTO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDTO supplier) {
		this.supplier = supplier;
	}

	@XmlElement
	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@XmlElement
	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	@XmlElement
	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@XmlElement
	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
}
