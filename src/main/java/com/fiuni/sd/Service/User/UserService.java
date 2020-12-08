package com.fiuni.sd.Service.User;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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



@Service
public class UserService extends BaseServiceImpl<UserDTO, User, UserResult> implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		final User userBeans = convertDtoToDomain(dto);
		final User user = userDAO.save(userBeans);
		return convertDomainToDto(user);
	}

	@Override
	@Transactional
	public UserDTO getById(Integer id) {
		if (userDAO.findById(id).isPresent()){
			final User userBeans = userDAO.findById(id).get();
			return convertDomainToDto(userBeans);
		}else {
			return null;
		}
	}


	@Override
	@Transactional
	public UserResult getAll(Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		Page<User> results=userDAO.findAll(pageable);
		results.forEach(user->users.add(convertDomainToDto(user)));
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		return userResult;
	}

	@Override
	protected UserDTO convertDomainToDto(User bean) {
		final UserDTO user = new UserDTO();
		user.setId(bean.getId());
		user.setUserName(bean.getUserName());
		user.setUserMail(bean.getEmail());
		user.setUserPassword(bean.getPassword());
		//user.set (bean.getRol_id());
		return user;
	}

	@Override
	protected User convertDtoToDomain(UserDTO dto) {
		User user = new User();
		user.setUserName(dto.getUserName());
		//user.setRol_id(dto.getRol_id());
		return user;
	}

	@Override
	public UserDTO update(UserDTO dto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Optional<User> deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}

