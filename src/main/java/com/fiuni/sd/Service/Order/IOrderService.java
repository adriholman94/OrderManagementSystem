package com.fiuni.sd.Service.Order;


import com.fiuni.sd.DTO.Order.OrderDTO;
import com.fiuni.sd.DTO.Order.OrderResult;
import com.fiuni.sd.Service.Base.IBaseService;



public interface IOrderService extends IBaseService<OrderDTO,OrderResult> {
	OrderDTO getById(Integer userId);
	OrderDTO deleteById(Integer Id);

}
