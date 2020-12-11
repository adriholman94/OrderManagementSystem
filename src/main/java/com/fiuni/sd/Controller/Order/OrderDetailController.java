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

import com.fiuni.sd.DTO.OrderDetails.OrderDetailDTO;
import com.fiuni.sd.DTO.OrderDetails.OrderDetailResult;
import com.fiuni.sd.Service.OrderDetail.IOrderDetailService;
import com.fiuni.sd.Utils.Setting;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController {
	
	@Autowired
	private Setting setting;

	@Autowired
	private IOrderDetailService orderDetailService;

	@GetMapping(path = "/{id}", produces = {"application/xml"})
	public OrderDetailDTO getById(@PathVariable(value = "id") Integer orderDetailId) {
		return orderDetailService.getById(orderDetailId);
	}

	@GetMapping(path = "/page/{page_num}", produces = {"application/xml"})
	public OrderDetailResult getRols(@PathVariable(value = "page_num") Integer pageNum) {
		return orderDetailService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
	}

	@PostMapping(path = "", produces = {"application/xml"})
	public OrderDetailDTO save(@Valid @RequestBody OrderDetailDTO orderDetail) {
		return orderDetailService.save(orderDetail);
	}

	@PutMapping(path ="/{id}", produces = {"application/xml"})
	public OrderDetailDTO update(@PathVariable final Integer id, @RequestBody final OrderDetailDTO orderDetail) {
		return orderDetailService.update(orderDetail, id);
	}

	@DeleteMapping(path ="/{id}", produces = {"application/xml"})
	public OrderDetailDTO delete(@PathVariable int id) {
		return orderDetailService.deleteById(id);
	}
}
