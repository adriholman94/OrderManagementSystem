package com.fiuni.sd.DTO.Base;

import java.io.Serializable;
import java.util.List;

public abstract class BaseResult<DTO extends BaseDTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DTO> _dtos;

	public List<DTO> getList() {
		return _dtos;
	}

	public void setList(List<DTO> dtos) {
		_dtos = dtos;
	}

	public Integer getTotal() {
		return null == _dtos ? 0 : _dtos.size();
	}
}