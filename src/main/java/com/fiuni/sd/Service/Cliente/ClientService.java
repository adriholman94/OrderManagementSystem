package com.fiuni.sd.Service.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Client.Client;
import com.fiuni.sd.DAO.Client.IClientDAO;
import com.fiuni.sd.DTO.Client.ClientDTO;
import com.fiuni.sd.DTO.Client.ClientResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;

@Service
public class ClientService extends BaseServiceImpl<ClientDTO, Client, ClientResult> implements IClientService {

	@Autowired
	private IClientDAO clientDAO;

	@Override
	@Transactional
	public ClientDTO save(ClientDTO dto) {
		final Client bean = new Client();
		bean.setName(dto.getFirstName());
		bean.setLastName(dto.getLastName());
		bean.setRUC(dto.getClientRuc());
		bean.setPhone(dto.getClientPhone());
		final Client role = clientDAO.save(bean);
		return convertBeanToDto(role);
	}

	@Override
	@Transactional
	public ClientResult getAll(Pageable pageable) {
		final List<ClientDTO> clients = new ArrayList<>();
		Page<Client> results = clientDAO.findAll(pageable);
		results.forEach(client -> clients.add(convertBeanToDto(client)));
		final ClientResult result = new ClientResult();
		result.setClient(clients);
		result.setPages(results.getTotalPages());
		return result;
	}

	@Override
	public ClientDTO convertBeanToDto(Client bean) {
		final ClientDTO DTO = new ClientDTO();
		DTO.setId(bean.getId());
		DTO.setFirstName(bean.getName());
		DTO.setLastName(bean.getLastName());
		DTO.setClientRuc(bean.getRUC());
		DTO.setClientPhone(bean.getPhone());
		return DTO;
	}

	@Override
	public Client convertDtoToBean(ClientDTO dto) {
		final Client bean = new Client();
		bean.setName(dto.getFirstName());
		bean.setLastName(dto.getLastName());
		bean.setRUC(dto.getClientRuc());
		bean.setPhone(dto.getClientPhone());
		return bean;
	}

	@Override
	@Transactional
	public ClientDTO update(ClientDTO dto, Integer id) {
		if (clientDAO.findById(id).isPresent()) {
			Client bean = clientDAO.findById(id).get();
			bean.setName(dto.getFirstName());
			bean.setLastName(dto.getLastName());
			bean.setRUC(dto.getClientRuc());
			bean.setPhone(dto.getClientPhone());
			Client updated = clientDAO.save(bean);
			return convertBeanToDto(updated);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public ClientDTO deleteById(Integer id) {
		ClientDTO bean = null;
		if (clientDAO.existsById(id)) {
			bean = null;
			clientDAO.deleteById(id);

		}
		return bean;
	}

	@Override
	public ClientDTO getById(Integer id) {
		if (clientDAO.findById(id).isPresent()) {
			final Client beans = clientDAO.findById(id).get();
			return convertBeanToDto(beans);
		} else {
			return null;
		}
	}
}
