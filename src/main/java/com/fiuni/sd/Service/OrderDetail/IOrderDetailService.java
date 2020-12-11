package com.fiuni.sd.Service.OrderDetail;


import com.fiuni.sd.DTO.OrderDetails.OrderDetailDTO;
import com.fiuni.sd.DTO.OrderDetails.OrderDetailResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface IOrderDetailService extends IBaseService<OrderDetailDTO, OrderDetailResult> {

	OrderDetailDTO getById(Integer OrderDetailId);
}
