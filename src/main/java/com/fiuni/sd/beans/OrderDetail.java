package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderDetailid", nullable = false, unique = true)
	private Integer orderDetailId;
	
	@Column(name = "productQuantity")
	private Integer productQuantity;

	@Column(name = "quantityPrice")
	private Integer quantityPrice;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	public Order get_productOrder() {
		return order;
	}

	public void set_productOrder(Order order) {
		this.order = order;
	}

	public Product getProducts() {
		return product;
	}

	public void setProducts(Product product) {
		this.product = product;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer OrderDetailId) {
		this.orderDetailId = OrderDetailId;
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
		return "OrderDetails[id=" + orderDetailId + ", productOrder=" + order + ", products="
				+ product + ", productQuantity=" + productQuantity + ", quantityPrice =" + quantityPrice + "]";
	}
}
