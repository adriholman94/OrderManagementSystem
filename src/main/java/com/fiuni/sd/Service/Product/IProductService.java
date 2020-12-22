package com.fiuni.sd.Service.Product;

import com.fiuni.sd.DTO.Product.ProductDTO;
import com.fiuni.sd.DTO.Product.ProductResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface IProductService extends IBaseService<ProductDTO, ProductResult> {

	ProductDTO getById(Integer roleId);

	ProductResult getProducts();
}
