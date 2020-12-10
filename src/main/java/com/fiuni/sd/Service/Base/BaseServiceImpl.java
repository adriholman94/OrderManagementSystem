package com.fiuni.sd.Service.Base;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Base.BaseResult;


public abstract class BaseServiceImpl<DTO extends BaseDTO, BEAN extends BaseBean,  RESULT extends BaseResult<DTO>> implements IBaseService<DTO, RESULT> {

	protected abstract DTO convertBeanToDto(BEAN bean);

	protected abstract BEAN convertDtoToBean(DTO dto);

}