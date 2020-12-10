package com.fiuni.sd.Service.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	public UserDTO getById(int id) {
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
        return userResult;
	}

	@Override
	protected UserDTO convertBeanToDto(User bean) {
		final UserDTO user = new UserDTO();
		user.setId(bean.getId());
		user.setUserName(bean.getUserName());

		user.setUserMail(bean.getEmail());
		user.setUserPassword(bean.getPassword());

		user.setUserMail(bean.getUserMail());
		user.setUserPassword(bean.getUserPassword());
		Set<RoleDTO> roles = new HashSet<>();
		bean.getRoles().forEach(role -> roles.add(convertBeanToDto(role)));
		user.setRoles(roles);

		return user;
	}

	@Override
	protected User convertDtoToBean(UserDTO dto) {
		final User user = new User();
		user.setUserName(dto.getUserName());

		user.setPassword(dto.getUserPassword());
		user.setEmail(dto.getUserMail());

		user.setUserPassword(dto.getUserPassword());
		user.setUserMail(dto.getUserMail());
		Set<Role> roles = new HashSet<>();
		dto.getRoles().forEach(role -> roles.add(convertDtoToBean(role)));
		user.setRoles(roles);

		return user;
	}


	public RoleDTO convertBeanToDto(Role bean) {
		final RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(bean.getRoleId());
		roleDTO.setRoleName(bean.getRoleName());
		return roleDTO;
	}


	protected Role convertDtoToBean(RoleDTO dto) {
		final Role roleBean = new Role();
		roleBean.setRoleId(dto.getId());
		roleBean.setRoleName(dto.getRoleName());
		return roleBean;
	}

	@Override
	@Transactional
	public UserDTO update(UserDTO dto, int id) {
		if (userDAO.findById(id).isPresent()){
            User userBean = userDAO.findById(id).get();
            userBean.setUserName(dto.getUserName());
            User updatedUser = userDAO.save(userBean);
            return convertBeanToDto(updatedUser);
        }else{
            return null;
        }
	}

	@Override
	@Transactional

	public UserDTO deleteById( Integer id){
		if (userDAO.findById(id).isPresent()){
            User userBean = userDAO.findById(id).get();
           // userBean.setUserName(dto.getUserName());
            
            User updatedUser = userDAO.save(userBean);
            return convertBeanToDto(updatedUser);
        }else{
            return null;
        }

	public Optional<User> deleteById(int id) {
		Optional<User> userBean = null;	
		if(userDAO.existsById(id)) {
			userBean = userDAO.findById(id);
			userDAO.deleteById(id);
		}
		return userBean;

	}
}
