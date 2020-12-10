package com.fiuni.sd.Service.User;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.User.User;
import com.fiuni.sd.DAO.User.IUserDAO;
import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.DTO.User.UserResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserService extends BaseServiceImpl<UserDTO, User, UserResult> implements IUserService {
	
	private Logger logger = LogManager.getLogger(UserService.class);

	@Autowired
	private IUserDAO userDAO;

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		final User userBeans = convertDtoToBean(dto);
		final User user = userDAO.save(userBeans);
		return convertBeanToDto(user);
	}

	@Override
	@Transactional
	public UserDTO getById(Integer id) {
		if (userDAO.findById(id).isPresent()) {
			final User userBeans = userDAO.findById(id).get();
			return convertBeanToDto(userBeans);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public UserResult getAll(Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		Page<User> results = userDAO.findAll(pageable);
		results.forEach(user -> users.add(convertBeanToDto(user)));
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		logger.info(userResult.list().size() + " " + userResult.getUsers().size());
        return userResult;
	}

	@Override
	protected UserDTO convertBeanToDto(User bean) {
		final UserDTO user = new UserDTO();
		user.setId(bean.getId());
		user.setUserName(bean.getUserName());
		user.setUserMail(bean.getUserMail());
		user.setUserPassword(bean.getUserPassword());
		return user;
	}

	@Override
	protected User convertDtoToBean(UserDTO dto) {
		final User user = new User();
		user.setUserName(dto.getUserName());
		user.setUserPassword(dto.getUserPassword());
		user.setUserMail(dto.getUserMail());
		return user;
	}

	@Override
	public UserDTO update(UserDTO dto, Integer id) {
		return null;
	}

}
