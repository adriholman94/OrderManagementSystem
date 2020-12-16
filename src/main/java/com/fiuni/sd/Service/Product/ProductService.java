package com.fiuni.sd.Service.Product;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Category.Category;
import com.fiuni.sd.Beans.Product.Product;
import com.fiuni.sd.DAO.Product.IProductDAO;
import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Product.ProductResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Service.Category.CategoryService;

@Service
public class ProductService extends BaseServiceImpl<ProductDTO, Product, ProductResult> implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		final Product bean = new Product();
		bean.setProductName(dto.getProductName());
		bean.setProductPrice(dto.getProductPrice());
		bean.setCategory(convertDtoToBean(dto.getCategory()));
		final Product product = productDAO.save(bean);
		return convertBeanToDto(product);
	}

	@Override
	@Transactional
	public ProductResult getAll(Pageable pageable) {
		final List<ProductDTO> products = new ArrayList<>();
		Page<Product> results = productDAO.findAll(pageable);
		results.forEach(product -> products.add(convertBeanToDto(product)));
		final ProductResult productResult = new ProductResult();
		productResult.setProduct(products);
		return productResult;
	}

	@Override
	public ProductDTO convertBeanToDto(Product bean) {
		final ProductDTO dto = new ProductDTO();
		dto.setId(bean.getProductId());
		dto.setProductName(bean.getProductName());
		dto.setProductPrice(bean.getProductPrice());
		dto.setCategory(new CategoryService().convertBeanToDto(bean.getCategory()));
		return dto;
	}

	@Override
	public Product convertDtoToBean(ProductDTO dto) {
		final Product bean = new Product();
		bean.setProductId(dto.getId());
		bean.setProductName(dto.getProductName());
		bean.setProductPrice(dto.getProductPrice());
		bean.setCategory(new CategoryService().convertDtoToBean(dto.getCategory()));
		return bean;
	}

	@Override
	@Transactional
	public ProductDTO update(ProductDTO dto, Integer id) {
		if (productDAO.findById(id).isPresent()) {
			Product bean = productDAO.findById(id).get();
			bean.setProductId(dto.getId());
			bean.setProductName(dto.getProductName());
			bean.setProductPrice(dto.getProductPrice());
			bean.setCategory(convertDtoToBean(dto.getCategory()));
			Product updated = productDAO.save(bean);
			return convertBeanToDto(updated);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public ProductDTO deleteById(Integer id) {
		ProductDTO bean = null;
		if (productDAO.existsById(id)) {
			bean = null;
			productDAO.deleteById(id);
		}
		return bean;
	}

	@Override
	public ProductDTO getById(Integer id) {
		if (productDAO.findById(id).isPresent()) {
			final Product roleBeans = productDAO.findById(id).get();
			return convertBeanToDto(roleBeans);
		} else {
			return null;
		}
	}


	public CategoryDTO convertBeanToDto(Category bean) {
		final CategoryDTO DTO = new CategoryDTO();
		DTO.setId(bean.getCategoryId());
		DTO.setCategoryName(bean.getCategoryName());
		return DTO;
	}


	protected Category convertDtoToBean(CategoryDTO dto) {
		final Category bean = new Category();
		bean.setCategoryId(dto.getId());
		bean.setCategoryName(dto.getCategoryName());
		return bean;
	}
}
