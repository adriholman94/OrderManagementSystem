package com.fiuni.sd.DAO.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.beans.Product.Product;

@Repository
public interface IProductDAO extends CrudRepository<Product, Integer> {

	public Page<Product> findAll(Pageable pageable);
}
