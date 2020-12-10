package com.fiuni.sd.Service.Base;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Base.BaseResult;


public interface IBaseService<DTO extends BaseDTO, R extends BaseResult<DTO>> {
	public DTO save(DTO dto);
	
	public DTO update(DTO dto,int id);

	public DTO getById(int id);
	
	public R getAll(Pageable pageable);

}