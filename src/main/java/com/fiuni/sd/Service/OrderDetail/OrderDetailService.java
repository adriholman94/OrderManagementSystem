package com.fiuni.sd.Service.OrderDetail;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Order.OrderDetail;
import com.fiuni.sd.DAO.Order.IOrderDetailDAO;
import com.fiuni.sd.DTO.OrderDetails.OrderDetailDTO;
import com.fiuni.sd.DTO.OrderDetails.OrderDetailResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;

@Service
public class OrderDetailService extends BaseServiceImpl<OrderDetailDTO, OrderDetail, OrderDetailResult> implements IOrderDetailService {

	@Autowired
	private IOrderDetailDAO orderDetailDAO;

	@Override
	@Transactional
	public OrderDetailDTO save(OrderDetailDTO dto) {
		final OrderDetail orderDetailBean = new OrderDetail();
		orderDetailBean.setProductQuantity(dto.getProductQuantity());
		orderDetailBean.setQuantityPrice(dto.getQuantityPrice());
		final OrderDetail orderDetail = orderDetailDAO.save(orderDetailBean);
		return convertBeanToDto(orderDetail);
	}

	@Override
	@Transactional
	public OrderDetailResult getAll(Pageable pageable) {
		final List<OrderDetailDTO> orderDetails = new ArrayList<>();
		Page<OrderDetail> results = orderDetailDAO.findAll(pageable);
		results.forEach(orderDetail -> orderDetails.add(convertBeanToDto(orderDetail)));
		final OrderDetailResult orderDetailResult = new OrderDetailResult();
		orderDetailResult.setProductOrderDetail(orderDetails);
		return orderDetailResult;
	}

	@Override
	public OrderDetailDTO convertBeanToDto(OrderDetail bean) {
		final OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		orderDetailDTO.setId(bean.getOrderDetailId());
		orderDetailDTO.setProductQuantity(bean.getProductQuantity()); 
		orderDetailDTO.setQuantityPrice(bean.getQuantityPrice());
		return orderDetailDTO;
	}

	@Override
	protected OrderDetail convertDtoToBean(OrderDetailDTO dto) {
		final OrderDetail orderDetailBean = new OrderDetail();
		orderDetailBean.setOrderDetailId(dto.getId());
		orderDetailBean.setProductQuantity(dto.getProductQuantity());
		orderDetailBean.setQuantityPrice(dto.getQuantityPrice());
		return orderDetailBean;
	}

	@Override
	@Transactional
	public OrderDetailDTO update(OrderDetailDTO dto, Integer id) {
		if (orderDetailDAO.findById(id).isPresent()) {
			OrderDetail orderDetailBean = orderDetailDAO.findById(id).get();
			orderDetailBean.setProductQuantity(dto.getProductQuantity());
			orderDetailBean.setQuantityPrice(dto.getQuantityPrice());
			OrderDetail updatedOrderDetail = orderDetailDAO.save(orderDetailBean);
			return convertBeanToDto(updatedOrderDetail);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public OrderDetailDTO deleteById(Integer id) {
		OrderDetailDTO orderDetailBean = null;
		if (orderDetailDAO.existsById(id)) {
			orderDetailBean = null;
			orderDetailDAO.deleteById(id);

		}
		return orderDetailBean;
	}

	@Override
	public OrderDetailDTO getById(Integer id) {
		if (orderDetailDAO.findById(id).isPresent()) {
			final OrderDetail orderDetailBeans = orderDetailDAO.findById(id).get();
			return convertBeanToDto(orderDetailBeans);
		} else {
			return null;
		}
	}
}
