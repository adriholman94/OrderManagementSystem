package com.fiuni.sd.Service.Stock;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Product.Product;
import com.fiuni.sd.Beans.Stock.Stock;
import com.fiuni.sd.DAO.Stock.IStockDAO;
import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Stock.StockDTO;
import com.fiuni.sd.DTO.Stock.StockResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Service.Product.ProductService;

@Service
public class StockService extends BaseServiceImpl<StockDTO, Stock, StockResult> implements IStockService {

	@Autowired
	private IStockDAO stockDAO;

	@Override
	@Transactional
	public StockDTO save(StockDTO dto) {
		final Stock bean = new Stock();

		bean.setProductQuantity(dto.getProductQuantity());
		bean.set_products(convertDtoToBean(dto.getProduct()));

		final Stock stock = stockDAO.save(bean);
		return convertBeanToDto(stock);
	}

	@Override
	@Transactional
	public StockResult getAll(Pageable pageable) {
		final List<StockDTO> stocks = new ArrayList<>();
		Page<Stock> results = stockDAO.findAll(pageable);
		results.forEach(stock -> stocks.add(convertBeanToDto(stock)));
		final StockResult stockResult = new StockResult();
		stockResult.setStock(stocks);
		stockResult.setPages(results.getTotalPages());
		return stockResult;
	}

	@Override
	public StockDTO convertBeanToDto(Stock bean) {
		final StockDTO dto = new StockDTO();
		dto.setId(bean.getStockId());
		dto.setProductQuantity(bean.getProductQuantity());
		dto.setProduct(new ProductService().convertBeanToDto(bean.get_product()));
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
	public StockDTO update(StockDTO dto, Integer id) {
		if (stockDAO.findById(id).isPresent()) {
			Stock bean = stockDAO.findById(id).get();
			bean.setStockId(dto.getId());

			bean.setProductQuantity(dto.getProductQuantity());
			bean.set_products(convertDtoToBean(dto.getProduct()));
			Stock updated = stockDAO.save(bean);
			return convertBeanToDto(updated);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public StockDTO deleteById(Integer id) {
		StockDTO dto = new StockDTO();
		if (stockDAO.existsById(id)) {
			dto = convertBeanToDto(stockDAO.findById(id).get());
			stockDAO.deleteById(id);
		}
		return dto;
	}

	@Override
	public StockDTO getById(Integer id) {
		if (stockDAO.findById(id).isPresent()) {
			final Stock roleBeans = stockDAO.findById(id).get();
			return convertBeanToDto(roleBeans);
		} else {
			return null;
		}
	}


	public ProductDTO convertBeanToDto(Product bean) {
		final ProductDTO DTO = new ProductDTO();
		DTO.setId(bean.getProductId());
		DTO.setProductName(bean.getProductName());
		return DTO;
	}


	protected Product convertDtoToBean(ProductDTO dto) {
		final Product bean = new Product();
		bean.setProductId(dto.getId());
		bean.setProductName(dto.getProductName());
		return bean;
	}
}
