package com.fiuni.sd.Service.Base;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Base.BaseResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;


public abstract class BaseServiceImpl<DTO extends BaseDTO, BEAN extends BaseBean,  RESULT extends BaseResult<DTO>> implements IBaseService<DTO, RESULT> {

	protected abstract DTO convertBeanToDto(BEAN bean);

	protected abstract BEAN convertDtoToBean(DTO dto);

	@Autowired
	private CacheManager cacheManager;

	protected CacheManager getCacheManager() {
		return cacheManager;
	}

}