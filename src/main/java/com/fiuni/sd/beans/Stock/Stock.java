package com.fiuni.sd.Beans.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.Product.Product;

import javax.persistence.Id;

@Entity
@Table(name = "Stock")
public class Stock implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false, unique = true)
	private Integer stockId;

	@Column(name = "product_Quantity")
	private Integer productQuantity;

	@OneToOne
	@JoinColumn(name = "product_Id")
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
