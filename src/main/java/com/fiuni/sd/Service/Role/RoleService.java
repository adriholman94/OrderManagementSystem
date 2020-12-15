package com.fiuni.sd.Service.Role;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Role.Role;
import com.fiuni.sd.DAO.Role.IRoleDAO;
import com.fiuni.sd.DTO.Role.RoleDTO;
import com.fiuni.sd.DTO.Role.RoleResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;

@Service
public class RoleService extends BaseServiceImpl<RoleDTO, Role, RoleResult> implements IRoleService {

	@Autowired
	private IRoleDAO roleDAO;

	@Override
	@Transactional
	public RoleDTO save(RoleDTO dto) {
		final Role roleBean = new Role();
		roleBean.setRoleName(dto.getRoleName());
		final Role role = roleDAO.save(roleBean);
		return convertBeanToDto(role);
	}

	@Override
	@Transactional
	public RoleResult getAll(Pageable pageable) {
		final List<RoleDTO> roles = new ArrayList<>();
		Page<Role> results = roleDAO.findAll(pageable);
		results.forEach(role -> roles.add(convertBeanToDto(role)));
		final RoleResult roleResult = new RoleResult();
		roleResult.setRoles(roles);
		return roleResult;
	}

	@Override
	public RoleDTO convertBeanToDto(Role bean) {
		final RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(bean.getRoleId());
		roleDTO.setRoleName(bean.getRoleName());
		return roleDTO;
	}

	@Override
	protected Role convertDtoToBean(RoleDTO dto) {
		final Role roleBean = new Role();
		roleBean.setRoleId(dto.getId());
		roleBean.setRoleName(dto.getRoleName());
		return roleBean;
	}

	@Override
	@Transactional
	public RoleDTO update(RoleDTO dto, Integer id) {
		if (roleDAO.findById(id).isPresent()) {
			Role roleBean = roleDAO.findById(id).get();
			roleBean.setRoleName(dto.getRoleName());
			Role updatedRole = roleDAO.save(roleBean);
			return convertBeanToDto(updatedRole);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public RoleDTO deleteById(Integer id) {
		RoleDTO roleBean = null;
		if (roleDAO.existsById(id)) {
			roleBean = null;
			roleDAO.deleteById(id);

		}
		return roleBean;
	}

	@Override
	public RoleDTO getById(Integer id) {
		if (roleDAO.findById(id).isPresent()) {
			final Role roleBeans = roleDAO.findById(id).get();
			return convertBeanToDto(roleBeans);
		} else {
			return null;
		}
	}
}
