package com.fiuni.sd.DAO.Product;

import java.util.List;

import com.fiuni.sd.Beans.Product.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDAO extends CrudRepository<Product, Integer> {

	public Page<Product> findAll(Pageable pageable);

	public List<Product> findAll();
}
