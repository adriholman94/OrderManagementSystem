package com.fiuni.sd.Service.Product;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Product.Product;
import com.fiuni.sd.DAO.Product.IProductDAO;
import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Product.ProductResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Service.Category.CategoryService;
import com.fiuni.sd.Utils.Setting;

@Service
public class ProductService extends BaseServiceImpl<ProductDTO, Product, ProductResult> implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	private static Logger logger = LogManager.getLogger(ProductService.class);

	@Override
	@Transactional
	@CachePut(value = Setting.cacheName, key = "'product_' + #dto.id", condition = "#dto.id!=null")
	public ProductDTO save(ProductDTO dto) {
		try {
			final Product bean = new Product();
			bean.setProductName(dto.getProductName());
			bean.setProductPrice(dto.getProductPrice());
			bean.setCategory(new CategoryService().convertDtoToBean(dto.getCategory()));
			final Product product = productDAO.save(bean);
			final ProductDTO newProduct = convertBeanToDto(product);
			if (dto.getId() == null) {
				getCacheManager().getCache(Setting.cacheName).put("product_" + product.getProductId(), newProduct);
			}
			return newProduct;
		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException("Error " + ProductService.class + " " + e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public ProductResult getAll(Pageable pageable) {
		final List<ProductDTO> categories = new ArrayList<>();
		Page<Product> results = productDAO.findAll(pageable);
		results.forEach(category -> categories.add(convertBeanToDto(category)));
		final ProductResult result = new ProductResult();
		result.setProducts(categories);
		result.setPages(results.getTotalPages());
		return result;
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
			bean.setCategory(new CategoryService().convertDtoToBean(dto.getCategory()));
			Product updated = productDAO.save(bean);
			return convertBeanToDto(updated);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	@Cacheable(value = Setting.cacheName, key = "'product_' + #id")
	public ProductDTO deleteById(Integer id) {
		ProductDTO dto = new ProductDTO();
		if (productDAO.existsById(id)) {
			dto = convertBeanToDto(productDAO.findById(id).get());
			productDAO.deleteById(id);
		}
		return dto;
	}

	@Override
	@Cacheable(value = Setting.cacheName, key = "'product_' + #id")
	public ProductDTO getById(Integer id) {
		if (productDAO.findById(id).isPresent()) {
			final Product roleBeans = productDAO.findById(id).get();
			return convertBeanToDto(roleBeans);
		} else {
			return null;
		}
	}

	@Override
	public ProductResult getProducts() {
		final List<ProductDTO> products = new ArrayList<>();
		List<Product> results = productDAO.findAll();
		results.forEach(category -> products.add(convertBeanToDto(category)));
		final ProductResult result = new ProductResult();
		result.setProducts(products);
		return result;
	}
}
