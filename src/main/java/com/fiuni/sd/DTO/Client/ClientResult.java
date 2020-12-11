package com.fiuni.sd.DTO.Client;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.sd.DTO.Base.BaseResult;
@XmlRootElement(name = "clientResult")
public class ClientResult extends BaseResult<ClientDTO> {

	private static final long serialVersionUID = 1L;
	@XmlElement
	public List<ClientDTO> getClients() {
		return list();
	}

	public void setClient(List<ClientDTO> dtos) {
		super.setList(dtos);
	}
}
