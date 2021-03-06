package com.fiuni.sd.DTO.Product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Category.CategoryDTO;

@XmlRootElement(name="products")
public class ProductDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	private String productName;
	private Integer productPrice;
	private CategoryDTO category;
	
	@XmlElement
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@XmlElement
	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
	@XmlElement
	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	@Override
	public String toString(){
		return "Product [productName= " + productName + ", category= " + category.getCategoryName() +
		", productPrice" + productPrice;
	}

}
