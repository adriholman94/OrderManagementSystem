package com.fiuni.sd.Beans.Category;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.Beans.Product.Product;
import javax.persistence.Id;

@Entity(name = "Categories")
public class Category implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_Id", nullable = false, unique = true)
	private Integer Id;

	@Column(name = "category_Name")
	private String categoryName;

	@OneToMany(mappedBy = "category")
	private Set<Product> products;

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

	public String toString() {
		return "Category [id=" + Id + ", category=" + categoryName + ", products=" + products + "]";
	}
}
