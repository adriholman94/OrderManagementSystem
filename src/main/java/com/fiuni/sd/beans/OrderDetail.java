package com.fiuni.sd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderDetailid", nullable = false, unique = true)
	private Integer productOrderDetailId;
	
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
		return "ProductOrderDetails[id=" + productOrderDetailId + ", productOrder=" + order + ", products="
				+ product + ", productQuantity=" + productQuantity + ", quantityPrice =" + quantityPrice + "]";
	}
}