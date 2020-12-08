package com.fiuni.sd.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiuni.sd.beans.User;



@Repository
public interface IUserDAO extends CrudRepository<User,Integer> {

	public Page<User> findAll(Pageable pageable);
}
