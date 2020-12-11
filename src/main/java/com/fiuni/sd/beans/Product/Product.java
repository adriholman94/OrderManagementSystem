package com.fiuni.sd.Beans.Product;

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

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.Category.Category;
import com.fiuni.sd.Beans.Order.OrderDetail;
import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecordDetail;
import com.fiuni.sd.Beans.Stock.Stock;

import javax.persistence.Id;

@Entity
@Table(name = "Products")
public class Product implements BaseBean {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_Id", nullable = false, unique = true)
	private Integer productId;

	@Column(name = "product_Name")
	private String productName;

	@Column(name = "product_Price")
	private Integer productPrice;

	@ManyToOne
	@JoinColumn(name = "category_Id")
	private Category category;

	@OneToOne(mappedBy = "product")
	private Stock stock;

	@OneToMany(mappedBy = "product")
	private Set<OrderDetail> orderDetail;

	@OneToMany(mappedBy = "product")
	private Set<PurchaseRecordDetail> purchaseRecordDetails;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void set_OrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
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
		return "Product [id=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", category=" + category.toString();
	}

}
