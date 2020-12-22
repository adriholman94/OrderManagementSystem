package com.fiuni.sd.DAO.Category;

import java.util.List;

import com.fiuni.sd.Beans.Category.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDAO extends CrudRepository<Category, Integer> {

	public Page<Category> findAll(Pageable pageable);

	public List<Category> findAll();
}
