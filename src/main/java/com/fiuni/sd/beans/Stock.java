package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "Stock")
public class Stock implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stockId", nullable = false, unique = true)
	private Integer stockId;

	@Column(name = "productQuantity")
	private Integer productQuantity;

	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;

	public Product get_product() {
		return product;
	}

	public void set_products(Product product) {
		this.product = product;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String toString() {
		return "stock[id=" + stockId + ",productQuantity=" + productQuantity + ", product=" + product + "]";
	}
}
