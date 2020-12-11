package com.fiuni.sd.Controller.PurchaseRecord;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordDTO;
import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordResult;
import com.fiuni.sd.Service.PurchaseRecord.IPurchaseRecordService;
import com.fiuni.sd.Utils.Setting;


@RestController
@RequestMapping("/purchases")
public class PurchaseRecordController {

	@Autowired
	private Setting setting;

	@Autowired
	private IPurchaseRecordService purchaseService;

	@GetMapping(path = "/{id}", produces = { "application/xml", "application/json" })
	public PurchaseRecordDTO getById(@PathVariable(value = "id") Integer purchaseId) {
		return purchaseService.getById(purchaseId);
	}

	@GetMapping(path = "/page/{page_num}", produces = { "application/xml", "application/json" })
	public PurchaseRecordResult getPurchaseRecords(@PathVariable(value = "page_num") Integer pageNum) {
		return purchaseService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
	}

	@PostMapping(produces = { "application/xml", "application/json" })
	public PurchaseRecordDTO save(@Valid @RequestBody PurchaseRecordDTO purchaseRecord) {
		return purchaseService.save(purchaseRecord);
	}

	@PutMapping(path ="/{id}", produces = {"application/xml", "application/json"})
	public PurchaseRecordDTO update(@PathVariable final Integer id, @RequestBody final PurchaseRecordDTO purchase) {
		return purchaseService.update(purchase, id);
	}
}
