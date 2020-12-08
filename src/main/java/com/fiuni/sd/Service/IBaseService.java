package com.fiuni.sd.Service;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.DTO.BaseDTO;
import com.fiuni.sd.DTO.BaseResult;
import com.fiuni.sd.beans.BaseBean;


public interface IBaseService<DOMAIN extends BaseBean,DTO extends BaseDTO, R extends BaseResult<DTO>> {
	public DTO save(DTO dto);
	
	public DTO update(DTO dto,Integer id);

	public DTO getById(Integer id);
	
	public R getAll(Pageable pageable);
	
	public Optional<DOMAIN> deleteById(Integer id);

}