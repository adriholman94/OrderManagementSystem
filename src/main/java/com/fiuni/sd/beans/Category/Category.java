package com.fiuni.sd.beans.Category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.beans.Base.BaseBean;
import com.fiuni.sd.beans.Product.Product;

import javax.persistence.Id;

@Entity
@Table(name = "Categories")
public class Category implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "category_Id", nullable = false, unique = true,columnDefinition = "serial")
	private Integer Id;

	@Column(name = "category_Name")
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
