package com.fiuni.sd.Service.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Order.Order;
import com.fiuni.sd.Beans.Order.OrderDetail;
import com.fiuni.sd.DAO.Order.IOrderDAO;
import com.fiuni.sd.DTO.Order.OrderDTO;
import com.fiuni.sd.DTO.Order.OrderResult;
import com.fiuni.sd.DTO.OrderDetails.OrderDetailDTO;
import com.fiuni.sd.Service.Base.BaseServiceImpl;

@Service
public class OrderService extends BaseServiceImpl<OrderDTO, Order, OrderResult> implements IOrderService {

	@Autowired

	private IOrderDAO orderDAO;


	@Override
	@Transactional
	@Secured({"ROLE_ADMIN", "ROLE_CLIENT"})
	public OrderDTO save(OrderDTO dto) {
		final Order order = convertDtoToBean(dto);
		final Set<OrderDetail> orderDetailsBean = new HashSet<>();
        final List<OrderDetailDTO> orderDetails = new ArrayList<>();
        if (dto.getOrderDetail() != null) {
            for (OrderDetailDTO orderDetail : dto.getOrderDetail()) {
                final OrderDetail orderDetailBean = convertDtoToBean(orderDetail);
                orderDetailsBean.add(orderDetailBean);
                orderDetails.add(convertBeanToDto(orderDetailBean));
            }
		}
		order.set_orderDetails(orderDetailsBean);
        final Order newOrder = orderDAO.save(order);
        OrderDTO orderDTO = null;
        if (newOrder != null) {
        	orderDTO  = convertBeanToDto(newOrder);
			orderDTO.setOrderDetail(orderDetails);
		}
        return orderDTO;
	}

	@Override
	@Transactional
	@Secured({"ROLE_ADMIN", "ROLE_CLIENT"})
	public OrderResult getAll(Pageable pageable) {
		final List<OrderDTO> orders = new ArrayList<>();
		Page<Order> results = orderDAO.findAll(pageable);
		results.forEach(order -> orders.add(convertBeanToDto(order)));
		final OrderResult orderResult = new OrderResult();
		orderResult.setOrder(orders);
		orderResult.setPages(results.getTotalPages());
		return orderResult;
	}

	@Override
	protected OrderDTO convertBeanToDto(Order bean) {
		final OrderDTO order = new OrderDTO();
		order.setId(bean.getOrderId());
		order.setClientRuc(bean.getClientRuc());
		order.setOrderDate(bean.getOrderDate());
		order.setIsCanceled(bean.getIsCanceled());
		order.setFinalPrice(bean.getFinalPrice());
		List<OrderDetailDTO> orderDetail = new ArrayList<>();
		bean.get_orderDetails().forEach(bean_ -> orderDetail.add(convertBeanToDto(bean_)));
		order.setOrderDetail(orderDetail);
		return order;
	}
	@Override
	protected Order convertDtoToBean(OrderDTO dto) {
		final Order order = new Order();
		order.setClientRuc(dto.getClientRuc());
		order.setOrderDate(dto.getOrderDate());
		order.setIsCanceled(dto.getIsCanceled());
		order.setFinalPrice(dto.getFinalPrice());
		Set<OrderDetail> roles = new HashSet<>();
		dto.getOrderDetail().forEach(role -> roles.add(convertDtoToBean(role)));
		order.set_orderDetails (roles);
		return order;
	}

	@Override
	@Transactional
	@Secured({"ROLE_ADMIN", "ROLE_CLIENT"})
	public OrderDTO update(OrderDTO dto, Integer id) {
		if (orderDAO.findById(id).isPresent()) {
			Order order = orderDAO.findById(id).get();
			order.setClientRuc(dto.getClientRuc());
			order.setOrderDate(dto.getOrderDate());
			order.setIsCanceled(dto.getIsCanceled());
			order.setFinalPrice(dto.getFinalPrice());
			Order updatedOrder = orderDAO.save(order);
			return convertBeanToDto(updatedOrder);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	@Secured({"ROLE_ADMIN", "ROLE_CLIENT"})
	public OrderDTO deleteById(Integer id) {
		OrderDTO orderBean = null;
		if (orderDAO.existsById(id)) {
			orderBean = convertBeanToDto(orderDAO.findById(id).get());
			orderDAO.deleteById(id);

		}
		return orderBean;
	}
	
	public OrderDetailDTO convertBeanToDto(OrderDetail bean) {
		final OrderDetailDTO orderDTO = new OrderDetailDTO();
		orderDTO.setOrderDetailId(bean.getOrderDetailId());
		orderDTO.setProductQuantity(bean.getProductQuantity());
		orderDTO.setQuantityPrice(bean.getQuantityPrice());
		return orderDTO;
	}

	protected OrderDetail convertDtoToBean(OrderDetailDTO dto) {
		final OrderDetail orderBean = new OrderDetail();
		orderBean.setOrderDetailId(dto.getOrderDetailId());
		orderBean.setProductQuantity(dto.getProductQuantity());
		orderBean.setQuantityPrice(dto.getQuantityPrice());
		return orderBean;
	}


	@Override
	@Secured({"ROLE_ADMIN", "ROLE_CLIENT"})
	public OrderDTO getById(Integer id) {
		if (orderDAO.findById(id).isPresent()) {
			final Order userBeans = orderDAO.findById(id).get();
			return convertBeanToDto(userBeans);
		} else {
			return null;
		}
	}
}
