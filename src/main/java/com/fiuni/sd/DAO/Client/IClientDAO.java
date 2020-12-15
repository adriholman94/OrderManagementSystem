package com.fiuni.sd.DAO.Client;

import com.fiuni.sd.Beans.Client.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDAO extends CrudRepository<Client, Integer> {

	public Page<Client> findAll(Pageable pageable);
}
