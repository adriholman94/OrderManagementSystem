package com.fiuni.sd.Service.Base;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Base.BaseResult;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseBean,  RESULT extends BaseResult<DTO>> implements IBaseService<DOMAIN ,DTO,   RESULT> {

	protected abstract DTO convertDomainToDto(DOMAIN domain);

	protected abstract DOMAIN convertDtoToDomain(DTO dto);

}