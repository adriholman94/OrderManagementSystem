package com.fiuni.sd.Controller.Stock;

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

import com.fiuni.sd.DTO.Stock.StockDTO;
import com.fiuni.sd.DTO.Stock.StockResult;
import com.fiuni.sd.Service.Stock.IStockService;
import com.fiuni.sd.Utils.Setting;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private Setting setting;

    @Autowired
    private IStockService stockService;

    @GetMapping(path = "/{id}", produces = { "application/xml" })
    public StockDTO getById(@PathVariable(value = "id") Integer Id) {
        return stockService.getById(Id);
    }

	@GetMapping(path = "/page/{page_num}", produces = {"application/xml", "application/json"})
	public StockResult getStocks(@PathVariable(value = "page_num") Integer pageNum) {
		return stockService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
	}

    @PostMapping(path = "", produces = { "application/xml" })
    public StockDTO save(@Valid @RequestBody StockDTO stock) {
        return stockService.save(stock);
    }

    @PutMapping(path = "/{id}", produces = { "application/xml" })
    public StockDTO update(@PathVariable final Integer id, @RequestBody final StockDTO stock) {
        return stockService.update(stock, id);
    }

    @DeleteMapping(path = "/{id}", produces = { "application/xml" })
    public StockDTO delete(@PathVariable int id) {
        return stockService.deleteById(id);
    }

    @GetMapping(path = "/all", produces = {"application/xml", "application/json"})
	public StockResult getAll() {
		return stockService.getStocks();
	}
}
