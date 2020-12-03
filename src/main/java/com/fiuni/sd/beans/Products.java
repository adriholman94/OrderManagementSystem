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
@Table(name = "products")
public class Products implements BaseBeans {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "productPrice")
	private Integer productPrice;

	@ManyToOne
	private Categories _categories;

	@OneToOne
	private ProductsSupplier _productsSupplier;

	@ManyToOne
	private Stock _stock;

	@OneToOne
	private ProductOrderDetail _productOrderDetail;

	public Categories get_categories() {
		return _categories;
	}

	public void set_categories(Categories _categories) {
		this._categories = _categories;
	}

	public Stock get_stock() {
		return _stock;
	}

	public void set_stock(Stock _stock) {
		this._stock = _stock;
	}

	public ProductOrderDetail get_productOrderDetail() {
		return _productOrderDetail;
	}

	public void set_productOrderDetail(ProductOrderDetail _productOrderDetail) {
		this._productOrderDetail = _productOrderDetail;
	}

	public ProductsSupplier get_productsSupplier() {
		return _productsSupplier;
	}

	public void set_productsSupplier(ProductsSupplier _productsSupplier) {
		this._productsSupplier = _productsSupplier;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String toString() {
		return "Product[id=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", _categories=" + _categories + ", _productsSupplier =" + _productsSupplier + ", _stock =" + _stock
				+ ", _productOrderDetail =" + _productOrderDetail + "]";
	}

}
