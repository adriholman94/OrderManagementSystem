package com.fiuni.sd.Service.Category;

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

import com.fiuni.sd.Beans.Category.Category;
import com.fiuni.sd.DAO.Category.ICategoryDAO;
import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Utils.Setting;

@Service
public class CategoryService extends BaseServiceImpl<CategoryDTO, Category, CategoryResult>
		implements ICategoryService {

	@Autowired
	private ICategoryDAO categoryDAO;

	private static Logger logger = LogManager.getLogger(CategoryService.class);

	@Override
	@Transactional
	@CachePut(value = Setting.cacheName, key = "'category_' + #dto.id", condition = "#dto.id!=null")
	public CategoryDTO save(CategoryDTO dto) {
		try {
			final Category bean = new Category();
			bean.setCategoryName(dto.getCategoryName());
			final Category role = categoryDAO.save(bean);
			final CategoryDTO newDto = convertBeanToDto(role);
			if (dto.getId() == null) {
				getCacheManager().getCache(Setting.cacheName).put("category_" + role.getCategoryId(), newDto);
			}
			return newDto;
		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException("Error " + CategoryService.class + " " + e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public CategoryResult getAll(Pageable pageable) {
		final List<CategoryDTO> categories = new ArrayList<>();
		Page<Category> results = categoryDAO.findAll(pageable);
		results.forEach(category -> categories.add(convertBeanToDto(category)));
		final CategoryResult result = new CategoryResult();
		result.setCategories(categories);
		result.setPages(results.getTotalPages());
		return result;
	}

	@Override
	public CategoryDTO convertBeanToDto(Category bean) {
		final CategoryDTO DTO = new CategoryDTO();
		DTO.setId(bean.getCategoryId());
		DTO.setCategoryName(bean.getCategoryName());
		return DTO;
	}

	@Override
	public Category convertDtoToBean(CategoryDTO dto) {
		final Category bean = new Category();
		bean.setCategoryId(dto.getId());
		bean.setCategoryName(dto.getCategoryName());
		return bean;
	}

	@Override
	@Transactional
	public CategoryDTO update(CategoryDTO dto, Integer id) {
		if (categoryDAO.findById(id).isPresent()) {
			Category bean = categoryDAO.findById(id).get();
			bean.setCategoryName(dto.getCategoryName());
			Category updated = categoryDAO.save(bean);
			return convertBeanToDto(updated);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	@Cacheable(value = Setting.cacheName, key = "'category_' + #id")
	public CategoryDTO deleteById(Integer id) {
		CategoryDTO dto = new CategoryDTO();
		if (categoryDAO.existsById(id)) {
			dto = convertBeanToDto(categoryDAO.findById(id).get());
			categoryDAO.deleteById(id);
		}
		return dto;
	}

	@Override
	@Cacheable(value = Setting.cacheName, key = "'category_' + #id")
	public CategoryDTO getById(Integer id) {
		if (categoryDAO.findById(id).isPresent()) {
			final Category beans = categoryDAO.findById(id).get();
			return convertBeanToDto(beans);
		} else {
			return null;
		}
	}

	@Override
	public CategoryResult getCategories() {
		final List<CategoryDTO> categories = new ArrayList<>();
		List<Category> results = categoryDAO.findAll();
		results.forEach(category -> categories.add(convertBeanToDto(category)));
		final CategoryResult result = new CategoryResult();
		result.setCategories(categories);
		return result;
	}
}
