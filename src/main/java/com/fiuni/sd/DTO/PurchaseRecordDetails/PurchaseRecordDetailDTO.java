package com.fiuni.sd.DTO.PurchaseRecordDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;

//registr de compra detalle
@XmlRootElement
public class PurchaseRecordDetailDTO extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private Integer purchaseRecordId;
	private Integer productsSupplierId;
	private Integer productQuantity;
	private Integer unitPrice;
	private Integer totalPrice;
	
	@XmlElement
	public Integer getPurchaseRecordId() {
		return purchaseRecordId;
	}
	public void setPurchaseRecordId(Integer purchaseRecordId) {
		this.purchaseRecordId = purchaseRecordId;
	}
	@XmlElement
	public Integer getProductsSupplierId() {
		return productsSupplierId;
	}
	public void setProductsSupplierId(Integer productsSupplierId) {
		this.productsSupplierId = productsSupplierId;
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



}
