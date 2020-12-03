package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "productOrderDetail")
public class ProductOrderDetail implements BaseBeans {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer productOrderDetailId;

	@ManyToOne
	private ProductOrder _productOrder;

	@OneToOne
	private Products _products;

	@Column(name = "productQuantity")
	private Integer productQuantity;

	@Column(name = "quantityPrice")
	private Integer quantityPrice;

	public ProductOrder get_productOrder() {
		return _productOrder;
	}

	public void set_productOrder(ProductOrder _productOrder) {
		this._productOrder = _productOrder;
	}

	public Products getProducts() {
		return _products;
	}

	public void setProducts(Products products) {
		this._products = products;
	}

	public Integer getProductOrderDetailId() {
		return productOrderDetailId;
	}

	public void setProductOrderDetailId(Integer productOrderDetailId) {
		this.productOrderDetailId = productOrderDetailId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Integer getQuantityPrice() {
		return quantityPrice;
	}

	public void setQuantityPrice(Integer quantityPrice) {
		this.quantityPrice = quantityPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "ProductOrderDetails[id=" + productOrderDetailId + ", productOrder=" + _productOrder + ", products="
				+ _products + ", productQuantity=" + productQuantity + ", quantityPrice =" + quantityPrice + "]";
	}
}
