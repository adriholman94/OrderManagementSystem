package com.fiuni.sd.Service.Cliente;


import com.fiuni.sd.DTO.Client.ClientDTO;
import com.fiuni.sd.DTO.Client.ClientResult;
import com.fiuni.sd.Service.Base.IBaseService;

public interface IClientService extends IBaseService<ClientDTO, ClientResult> {

	ClientDTO getById(Integer Id);
}
