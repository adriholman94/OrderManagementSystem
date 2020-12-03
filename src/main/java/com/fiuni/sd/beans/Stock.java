package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
@Entity
@Table(name = "stock")
public class Stock implements BaseBeans{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer	stockId;
	

	
	@Column(name = "productQuantity")
	private Integer	productQuantity;
	
	@OneToMany(mappedBy="_stock")
	private Set<Products>_products= new HashSet<>();
	
	
   public Set<Products> get_products() {
		return _products;
	}
	public void set_products(Set<Products> _products) {
		this._products = _products;
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
		return "stock[id=" + stockId + ",productQuantity=" + productQuantity + ", _products=" + _products +"]";
	}
}
