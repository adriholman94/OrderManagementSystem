package com.fiuni.sd.DAO.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.beans.Category.Category;




@Repository
public interface ICategoryDAO extends CrudRepository<Category, Integer> {

	public Page<Category> findAll(Pageable pageable);
}
