package com.fiuni.sd.DAO.Supplier;

import java.util.List;

import com.fiuni.sd.Beans.Supplier.Supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierDAO extends CrudRepository<Supplier, Integer> {

	public Page<Supplier> findAll(Pageable pageable);

	public List<Supplier> findAll();
}
