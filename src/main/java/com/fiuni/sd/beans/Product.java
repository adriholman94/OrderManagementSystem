package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Products")
public class Product implements BaseBean {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId", nullable = false, unique = true)
	private Integer productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "productPrice")
	private Integer productPrice;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category categories;

	@OneToOne
	@JoinColumn(name = "productSupplierId")
	private ProductsSupplier productsSupplier;

	@OneToOne
	private Stock stock;

	@OneToMany
	private OrderDetail orderDetail;

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

	public OrderDetail get_productOrderDetail() {
		return orderDetail;
	}

	public void set_productOrderDetail(OrderDetail orderDetail) {
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
