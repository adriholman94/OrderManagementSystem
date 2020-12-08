package com.fiuni.sd.DAO.Role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.beans.Role.Role;



@Repository
public interface IRoleDAO extends CrudRepository<Role, Integer> {

	public Page<Role> findAll(Pageable pageable);
}