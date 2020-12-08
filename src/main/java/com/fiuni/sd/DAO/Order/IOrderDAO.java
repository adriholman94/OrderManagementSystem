package com.fiuni.sd.DAO.Order;
import com.fiuni.sd.Beans.Order.Order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDAO extends CrudRepository<Order, Integer> {

	public Page<Order> findAll(Pageable pageable);
}
