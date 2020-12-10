package com.fiuni.sd.Service.Base;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.fiuni.sd.Beans.Base.BaseBean;
import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fiuni.sd.DTO.Base.BaseResult;


public interface IBaseService<BEAN extends BaseBean,DTO extends BaseDTO, R extends BaseResult<DTO>> {
	public DTO save(DTO dto);
	
	public DTO update(DTO dto,Integer id);

	public DTO getById(Integer id);
	
	public R getAll(Pageable pageable);
	
	public Optional<BEAN> deleteById(Integer id);

}