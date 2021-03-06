package com.fiuni.sd.DAO.User;

import java.util.List;

import com.fiuni.sd.Beans.Category.Category;
import com.fiuni.sd.Beans.User.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO extends CrudRepository<User, Integer> {
	
	public Page<User> findAll(Pageable pageable);

	public List<User> findByUserName(String username);

	public List<User> findAll();
}
