package com.fiuni.sd.Controller.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.fiuni.sd.DTO.Client.ClientDTO;
import com.fiuni.sd.DTO.Client.ClientResult;
import com.fiuni.sd.Service.Cliente.IClientService;
import com.fiuni.sd.Utils.Setting;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private Setting setting;

	@Autowired
	private IClientService clientService;

	@GetMapping(path = "/{id}", produces = {"application/xml"})
	public ClientDTO getById(@PathVariable(value = "id") Integer clientId) {
		return clientService.getById(clientId);
	}

	@GetMapping(path = "/page/{page_num}", produces = {"application/xml"})
	public ClientResult getRols(@PathVariable(value = "page_num") Integer pageNum) {
		return clientService.getAll(PageRequest.of(pageNum, setting.getPage_size()));
	}

	@PostMapping(path = "", produces = {"application/xml"})
	public ClientDTO save(@Valid @RequestBody ClientDTO client) {
		return clientService.save(client);
	}

	@PutMapping(path ="/{id}", produces = {"application/xml"})
	public ClientDTO update(@PathVariable final Integer id, @RequestBody final ClientDTO client) {
		return clientService.update(client, id);
	}


	@DeleteMapping(path ="/{id}", produces = {"application/xml"})
	public ClientDTO delete(@PathVariable int id) {
		return clientService.deleteById(id);
	}
}
