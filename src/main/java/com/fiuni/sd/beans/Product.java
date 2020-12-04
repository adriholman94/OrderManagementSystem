package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "Products")
public class Product implements BaseBean {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_Id", nullable = false, unique = true)
	private Integer productId;

	@Column(name = "product_Name")
	private String productName;

	@Column(name = "product_Price")
	private Integer productPrice;

	@ManyToOne
	@JoinColumn(name = "category_Id")
	private Category categories;

	@OneToOne
	@JoinColumn(name = "product_Supplier_Id")
	private ProductsSupplier productsSupplier;

	@OneToOne
	private Stock stock;

	@OneToMany
	private Set<OrderDetail> orderDetail = new HashSet<>();

	public Category get_categories() {
		return categories;
	}

	public void set_categories(Category categories) {
		this.categories = categories;
	}

	public Stock get_stock() {
		return stock;
	}

	public void set_stock(Stock stock) {
		this.stock = stock;
	}

	public Set<OrderDetail> get_productOrderDetail() {
		return orderDetail;
	}

	public void set_productOrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public ProductsSupplier get_productsSupplier() {
		return productsSupplier;
	}

	public void set_productsSupplier(ProductsSupplier productsSupplier) {
		this.productsSupplier = productsSupplier;
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
				+ ", categories=" + categories + ", productsSupplier =" + productsSupplier + ", stock =" + stock
				+ ", orderDetail =" + orderDetail + "]";
	}

}
