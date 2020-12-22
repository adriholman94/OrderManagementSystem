package com.fiuni.sd.Controller.Supplier;

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


import com.fiuni.sd.DTO.Supplier.SupplierDTO;
import com.fiuni.sd.DTO.Supplier.SupplierResult;
import com.fiuni.sd.Service.Supplier.ISupplierService;
import com.fiuni.sd.Utils.Setting;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	private Setting setting;

	@Autowired
	private ISupplierService supplierService;

	@GetMapping(path = "/{id}", produces = {"application/xml"})
	public SupplierDTO getById(@PathVariable(value = "id") Integer supplierId) {
		return supplierService.getById(supplierId);
	}

	@GetMapping(path = "/page/{page_num}", produces = {"application/xml"})
	public SupplierResult getSuppliers(@PathVariable(value = "page_num") Integer pageNum) {
		return supplierService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
	}

	@PostMapping(path = "", produces = {"application/xml"})
	public SupplierDTO save(@Valid @RequestBody SupplierDTO supplier) {
		return supplierService.save(supplier);
	}

	@PutMapping(path ="/{id}", produces = {"application/xml"})
	public SupplierDTO update(@PathVariable final Integer id, @RequestBody final SupplierDTO Supplier) {
		return supplierService.update(Supplier, id);
	}

	@DeleteMapping(path ="/{id}", produces = {"application/xml"})
	public SupplierDTO delete(@PathVariable int id) {
		return supplierService.deleteById(id);
	}

	@GetMapping(path = "/all", produces = {"application/xml", "application/json"})
	public SupplierResult getAll() {
		return supplierService.getSuppliers();
	}
}
