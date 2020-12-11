package com.fiuni.sd.Service.Category;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Category.Category;
import com.fiuni.sd.DAO.Category.ICategoryDAO;
import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;

@Service
public class CategoryService extends BaseServiceImpl<CategoryDTO, Category, CategoryResult> implements ICategoryService {

	@Autowired
	private ICategoryDAO categoryDAO;

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO dto) {
		final Category bean = new Category();
		bean.setCategoryName(dto.getCategoryName());
		final Category role = categoryDAO.save(bean);
		return convertBeanToDto(role);
	}

	@Override
	@Transactional
	public CategoryResult getAll(Pageable pageable) {
		final List<CategoryDTO> categories = new ArrayList<>();
		Page<Category> results = categoryDAO.findAll(pageable);
		results.forEach(category -> categories.add(convertBeanToDto(category)));
		final CategoryResult result = new CategoryResult();
		result.setCategories(categories);
		return result;
	}

	@Override
	public CategoryDTO convertBeanToDto(Category bean) {
		final CategoryDTO DTO = new CategoryDTO();
		DTO.setId(bean.getId());
		DTO.setCategoryName(bean.getCategoryName());
		return DTO;
	}

	@Override
	protected Category convertDtoToBean(CategoryDTO dto) {
		final Category bean = new Category();
		bean.setId(dto.getId());
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
	public CategoryDTO deleteById(Integer id) {
		CategoryDTO bean = null;
		if (categoryDAO.existsById(id)) {
			bean = null;
			categoryDAO.deleteById(id);

		}
		return bean;
	}

	@Override
	public CategoryDTO getById(Integer id) {
		if (categoryDAO.findById(id).isPresent()) {
			final Category beans = categoryDAO.findById(id).get();
			return convertBeanToDto(beans);
		} else {
			return null;
		}
	}
}
