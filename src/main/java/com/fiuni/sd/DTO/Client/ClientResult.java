package com.fiuni.sd.DTO.Client;

import java.util.List;

import com.fiuni.sd.DTO.Base.BaseResult;

public class ClientResult extends BaseResult<ClientDTO> {

	private static final long serialVersionUID = 1L;

	public List<ClientDTO> getClients() {
		return getList();
	}

	public void setClient(List<ClientDTO> dtos) {
		super.setList(dtos);
	}
}
