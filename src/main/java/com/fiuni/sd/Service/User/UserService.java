package com.fiuni.sd.Service.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Role.Role;
import com.fiuni.sd.Beans.User.User;
import com.fiuni.sd.DAO.User.IUserDAO;
import com.fiuni.sd.DTO.Role.RoleDTO;

import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.DTO.User.UserResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;

@Service
public class UserService extends BaseServiceImpl<UserDTO, User, UserResult> implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	@Transactional
	@Secured("ROLE_ADMIN")
	public UserDTO save(UserDTO dto) {
		final User user = new User();
		user.setUserMail(dto.getUserMail());
		user.setUserName(dto.getUserName());
		user.setUserPassword(dto.getUserPassword());
		
		final Set<Role> rolesBean = new HashSet<>();
        final List<RoleDTO> roles = new ArrayList<>();
        if (dto.getRoles() != null) {
            for (RoleDTO role : dto.getRoles()) {
                final Role roleBean = convertDtoToBean(role);
                rolesBean.add(roleBean);
                roles.add(convertBeanToDto(roleBean));
            }
		}
		
		user.setRoles(rolesBean);
        final User newUser = userDAO.save(user);
        UserDTO userDTO = null;
        if (newUser != null) {
        	userDTO  = convertBeanToDto(newUser);
			userDTO.setRoles(roles);
		}
        return userDTO;
	}

	@Override
	@Transactional
	@Secured("ROLE_ADMIN")
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
	@Secured("ROLE_ADMIN")
	public UserResult getAll(Pageable pageable) {
		final List<UserDTO> users = new ArrayList<>();
		Page<User> results = userDAO.findAll(pageable);
		results.forEach(user -> users.add(convertBeanToDto(user)));
		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		userResult.setPages(results.getTotalPages());
		return userResult;
	}

	@Override
	protected UserDTO convertBeanToDto(User bean) {
		final UserDTO user = new UserDTO();
		user.setId(bean.getId());
		user.setUserName(bean.getUserName());
		user.setUserMail(bean.getUserMail());
		user.setUserPassword(bean.getUserPassword());
		List<RoleDTO> roles = new ArrayList<>();
		bean.getRoles().forEach(role -> roles.add(convertBeanToDto(role)));
		user.setRoles(roles);
		return user;
	}

	@Override
	protected User convertDtoToBean(UserDTO dto) {
		final User user = new User();
		user.setUserName(dto.getUserName());
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
	@Secured("ROLE_ADMIN")
	public UserDTO update(UserDTO dto, Integer id) {
		if (userDAO.findById(id).isPresent()) {
			User userBean = userDAO.findById(id).get();
			userBean.setUserName(dto.getUserName());
			User updatedUser = userDAO.save(userBean);
			return convertBeanToDto(updatedUser);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	@Secured("ROLE_ADMIN")
	public UserDTO deleteById(Integer id) {
		UserDTO bean = null;
		if (userDAO.existsById(id)) {
			bean = null;
			userDAO.deleteById(id);

		}
		return bean;
	}

	@Override
	@Transactional
	public UserDTO findByUserName(String username) {
        List<User> results = userDAO.findByUserName(username);
        final UserDTO user = 0 == results.size() ? new UserDTO() : convertBeanToDto(results.get(0));
        return user;
	}
}
