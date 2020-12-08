package com.fiuni.sd.Service;

import com.fiuni.sd.DTO.BaseDTO;
import com.fiuni.sd.DTO.BaseResult;
import com.fiuni.sd.beans.BaseBean;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseBean,  RESULT extends BaseResult<DTO>> implements IBaseService<DOMAIN ,DTO,   RESULT> {

	protected abstract DTO convertDomainToDto(DOMAIN domain);

	protected abstract DOMAIN convertDtoToDomain(DTO dto);

}