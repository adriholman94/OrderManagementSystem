package com.fiuni.sd.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "productOrder")
public class ProductOrder implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer productOrderId;

	@Column(name = "orderDate")
	private Date orderDate;

	@ManyToOne
	private Client _clients;

	@Column(name = "finalPrice")
	private Integer finalPrice;

	@Column(name = "isCanceled")
	private Boolean isCanceled;

	@OneToMany(mappedBy = "_productOrder")
	private Set<ProductOrderDetail> _productOrderDetails = new HashSet<>();

	public Client get_clients() {
		return _clients;
	}

	public void set_clients(Client _clients) {
		this._clients = _clients;
	}

	public Set<ProductOrderDetail> get_productOrderDetails() {
		return _productOrderDetails;
	}

	public void set_productOrderDetails(Set<ProductOrderDetail> _productOrderDetails) {
		this._productOrderDetails = _productOrderDetails;
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
		return "ProductOrder [id=" + productOrderId + ", orderDate=" + orderDate + ", cliente=" + _clients
				+ ", final price=" + finalPrice + ", estado =" + isCanceled + ", _productOrderDetails ="
				+ _productOrderDetails + "]";
	}
}
