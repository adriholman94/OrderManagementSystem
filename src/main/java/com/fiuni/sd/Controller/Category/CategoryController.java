package com.fiuni.sd.Controller.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fiuni.sd.Service.Category.ICategoryService;
import com.fiuni.sd.Utils.Setting;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private Setting setting;

	@Autowired
	private ICategoryService categoryService;

	@GetMapping(path = "/{id}", produces = {"application/xml"})
	public CategoryDTO getById(@PathVariable(value = "id") Integer Id) {
		return categoryService.getById(Id);
	}

	@GetMapping(path = "/page/{page_num}", produces = {"application/xml"})
	public CategoryResult getCategories(@PathVariable(value = "page_num") Integer pageNum) {
		return categoryService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
	}

	@PostMapping(path = "", produces = {"application/xml"})
	public CategoryDTO save(@Valid @RequestBody CategoryDTO category) {
		return categoryService.save(category);
	}

	@PutMapping(path ="/{id}", produces = {"application/xml"})
	public CategoryDTO update(@PathVariable final Integer id, @RequestBody final CategoryDTO category) {
		return categoryService.update(category, id);
	}


	@DeleteMapping(path ="/{id}", produces = {"application/xml"})
	public CategoryDTO delete(@PathVariable int id) {
		return categoryService.deleteById(id);
	}
}
