package com.fiuni.sd.DAO.Role;

import com.fiuni.sd.Beans.Role.Role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IRoleDAO extends CrudRepository<Role, Integer> {

	public Page<Role> findAll(Pageable pageable);
}