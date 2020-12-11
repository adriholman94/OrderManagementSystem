package com.fiuni.sd.Service.Category;


import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface ICategoryService extends IBaseService<CategoryDTO, CategoryResult> {

	CategoryDTO getById(Integer Id);
}
