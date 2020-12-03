package com.fiuni.sd.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "Categories")
public class Category implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryId", nullable = false, unique = true)
	private Integer Id;

	@Column(name = "categoryName")
	private String categoryName;

	@OneToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>();

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void set_products(Set<Product> products) {
		this.products = products;
	}

	public Set<Product> get_products() {
		return products;
	}

	public String toString() {
		return "Categories [id=" + Id + ", category=" + categoryName + ", products=" + products +"]";
	}
}
