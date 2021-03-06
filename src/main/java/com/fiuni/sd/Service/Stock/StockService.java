package com.fiuni.sd.Service.Stock;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import com.fiuni.sd.Beans.Stock.Stock;
import com.fiuni.sd.DAO.Stock.IStockDAO;

import com.fiuni.sd.DTO.Stock.StockDTO;
import com.fiuni.sd.DTO.Stock.StockResult;

import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Service.Product.ProductService;
import com.fiuni.sd.Service.Stock.StockService;

@Service
public class StockService extends BaseServiceImpl<StockDTO, Stock, StockResult> implements IStockService {

	@Autowired
	private IStockDAO stockDAO;

	@Override
	@Transactional
	@Secured("ROLE_ADMIN")
	public StockDTO save(StockDTO dto) {
		final Stock bean = new Stock();
		bean.setProductQuantity(dto.getProductQuantity());
		bean.set_products(new ProductService().convertDtoToBean(dto.getProduct()));
		final Stock product = stockDAO.save(bean);
		return convertBeanToDto(product);
	}

	@Override
	@Transactional
	@Secured("ROLE_ADMIN")
	public StockResult getAll(Pageable pageable) {
		final List<StockDTO> products = new ArrayList<>();
		Page<Stock> results = stockDAO.findAll(pageable);
		results.forEach(category -> products.add(convertBeanToDto(category)));
		final StockResult result = new StockResult();
		result.setStock(products);
		result.setPages(results.getTotalPages());
		return result;
	}

	@Override
	public StockDTO convertBeanToDto(Stock bean) {
		final StockDTO dto = new StockDTO();
		dto.setId(bean.getStockId());
		dto.setProductQuantity(bean.getProductQuantity());
		bean.set_products(new ProductService().convertDtoToBean(dto.getProduct()));
		return dto;
	}

	@Override
	public Stock convertDtoToBean(StockDTO dto) {
		final Stock bean = new Stock();
		bean.setStockId(dto.getId());
		bean.setProductQuantity(dto.getProductQuantity());
		bean.set_products(new ProductService().convertDtoToBean(dto.getProduct()));
		return bean;
	}

	@Override
	@Transactional
	@Secured("ROLE_ADMIN")
	public StockDTO update(StockDTO dto, Integer id) {
		if (stockDAO.findById(id).isPresent()) {
			Stock bean = stockDAO.findById(id).get();
			bean.setStockId(dto.getId());
			bean.setProductQuantity(dto.getProductQuantity());
			bean.set_products(new ProductService().convertDtoToBean(dto.getProduct()));
			Stock updated = stockDAO.save(bean);
			return convertBeanToDto(updated);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	@Secured("ROLE_ADMIN")
	public StockDTO deleteById(Integer id) {
		StockDTO dto = new StockDTO();
		if (stockDAO.existsById(id)) {
			dto = convertBeanToDto(stockDAO.findById(id).get());
			stockDAO.deleteById(id);
		}
		return dto;
	}

	@Override
	@Secured("ROLE_ADMIN")
	public StockDTO getById(Integer id) {
		if (stockDAO.findById(id).isPresent()) {
			final Stock roleBeans = stockDAO.findById(id).get();
			return convertBeanToDto(roleBeans);
		} else {
			return null;
		}
	}

	@Override
	public StockResult getStocks() {
		final List<StockDTO> products = new ArrayList<>();
		List<Stock> results = stockDAO.findAll();
		results.forEach(product -> products.add(convertBeanToDto(product)));
		final StockResult result = new StockResult();
		result.setStock(products);
		return result;
	}
}
