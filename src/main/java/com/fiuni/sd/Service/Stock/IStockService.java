package com.fiuni.sd.Service.Stock;

import com.fiuni.sd.DTO.Stock.StockDTO;
import com.fiuni.sd.DTO.Stock.StockResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface IStockService extends IBaseService<StockDTO, StockResult> {

	StockDTO getById(Integer roleId);
}
