package com.fiuni.sd.DAO.Order;

	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

import com.fiuni.sd.beans.Order.OrderDetail;




	@Repository
	public interface IOrderDetailDAO extends CrudRepository<OrderDetail, Integer> {

		public Page<OrderDetail> findAll(Pageable pageable);
	}
