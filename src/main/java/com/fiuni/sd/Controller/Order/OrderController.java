package com.fiuni.sd.Controller.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.fiuni.sd.DTO.Order.OrderDTO;
import com.fiuni.sd.DTO.Order.OrderResult;
import com.fiuni.sd.Service.Order.IOrderService;
import com.fiuni.sd.Utils.Setting;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private Setting setting;

	@Autowired
	private IOrderService orderService;

	@GetMapping(path = "/{id}", produces = {"application/xml"})
	public OrderDTO getById(@PathVariable(value = "id") Integer orderId) {
		return orderService.getById(orderId);
	}

	@GetMapping(path = "/page/{page_num}", produces = {"application/xml"})
	public OrderResult getOrders(@PathVariable(value = "page_num") Integer pageNum) {
		return orderService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
	}

	@PostMapping(path = "", produces = {"application/xml"})
	public OrderDTO save(@Valid @RequestBody OrderDTO order) {
		return orderService.save(order);
	}

	@PutMapping(path ="/{id}", produces = {"application/xml"})
	public OrderDTO update(@PathVariable final Integer id, @RequestBody final OrderDTO order) {
		return orderService.update(order, id);
	}

	@DeleteMapping(path ="/{id}", produces = {"application/xml"})
	public OrderDTO delete(@PathVariable int id) {
		return orderService.deleteById(id);
	}
}
