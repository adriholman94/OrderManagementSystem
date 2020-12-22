package com.fiuni.sd.DAO.Stock;



import com.fiuni.sd.Beans.Stock.Stock;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockDAO extends CrudRepository<Stock, Integer> {

	public Page<Stock> findAll(Pageable pageable);
	public List<Stock> findAll();
}
