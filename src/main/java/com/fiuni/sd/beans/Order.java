package com.fiuni.sd.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "ProductOrder")
public class Order implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId", nullable = false, unique = true)
	private Integer productOrderId;

	@Column(name = "orderDate")
	private Date orderDate;

	@Column(name = "finalPrice")
	private Integer finalPrice;

	@Column(name = "isCanceled")
	private Boolean isCanceled;

	@OneToMany(mappedBy = "Order")
	private Set<OrderDetail> orderDetails = new HashSet<>();

	public Set<OrderDetail> get_orderDetails() {
		return orderDetails;
	}

	public void set_productOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Integer getProductOrderId() {
		return productOrderId;
	}

	public void setProductOrderId(Integer productOrderId) {
		this.productOrderId = productOrderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public String toString() {
		return "ProductOrder [id=" + productOrderId + ", orderDate=" + orderDate
				+ ", final price=" + finalPrice + ", estado =" + isCanceled + ", orderDetails ="
				+ orderDetails + "]";
	}
}
