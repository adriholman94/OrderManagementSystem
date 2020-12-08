package com.fiuni.sd.Beans.Order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.Beans.Base.BaseBean;

import javax.persistence.Id;

@Entity
@Table(name = "Orders")
public class Order implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_Id", nullable = false, unique = true)
	private Integer orderId;

	@Column(name = "order_Date")
	private Date orderDate;

	@Column(name = "final_Price")
	private Integer finalPrice;

	@Column(name = "is_Canceled")
	private Boolean isCanceled;

	@OneToMany(mappedBy = "order")
	private Set<OrderDetail> orderDetails = new HashSet<>();

	public Set<OrderDetail> get_orderDetails() {
		return orderDetails;
	}

	public void set_orderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer OrderId) {
		this.orderId = OrderId;
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
		return "Order [id=" + orderId + ", orderDate=" + orderDate
				+ ", final price=" + finalPrice + ", estado =" + isCanceled + ", orderDetails ="
				+ orderDetails + "]";
	}
}
