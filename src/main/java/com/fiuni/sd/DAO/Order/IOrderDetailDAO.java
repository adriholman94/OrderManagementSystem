package com.fiuni.sd.DAO.Order;

	import com.fiuni.sd.Beans.Order.OrderDetail;

import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;




	@Repository
	public interface IOrderDetailDAO extends CrudRepository<OrderDetail, Integer> {

		public Page<OrderDetail> findAll(Pageable pageable);
	}
