package com.fiuni.sd.DTO.PurchaseRecordDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Supplier.SupplierDTO;

//registr de compra detalle
@XmlRootElement(name = "purchaseRecordDetail")
public class PurchaseRecordDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private Integer purchaseRecord;
	private SupplierDTO supplier;
	private ProductDTO product;
	private Integer productQuantity;
	private Integer unitPrice;
	private Integer totalPrice;

	@XmlElement
	public Integer getPurchaseRecord() {
		return purchaseRecord;
	}

	public void setPurchaseRecord(Integer purchaseRecord) {
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

	@Override
	public String toString() {
		return "PurcaseRecordDetail [product= " + product.getProductName() + ", category= "
				+ product.getCategory().getCategoryName() + ", supplier= " + supplier.getSupplierName() + ", quantity= "
				+ String.valueOf(productQuantity) + ", unitPrice= " + String.valueOf(unitPrice) + ", totalPrice= "
				+ String.valueOf(totalPrice) + "]";
	}
}
