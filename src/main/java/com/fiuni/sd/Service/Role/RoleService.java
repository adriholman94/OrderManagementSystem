package com.fiuni.sd.Service.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		final Role roleBeans = convertDtoToDomain(dto);
		final Role role = roleDAO.save(roleBeans);
		return convertDomainToDto(role);
	}

	@Override
	@Transactional
	public RoleResult getAll(Pageable pageable) {
		final List<RoleDTO> roles = new ArrayList<>();
		Page<Role> results = roleDAO.findAll(pageable);
		results.forEach(role -> roles.add(convertDomainToDto(role)));
		final RoleResult roleResult = new RoleResult();
		roleResult.setRoles(roles);
		return roleResult;
	}

	@Override
	public RoleDTO convertDomainToDto(Role bean) {
		final RoleDTO role = new RoleDTO();
		role.setId(bean.getRoleId());
		role.setRoleName(bean.getRoleName());
		return role;
	}

	@Override
	protected Role convertDtoToDomain(RoleDTO dto) {
		final Role role = new Role();
		role.setRoleId(dto.getId());
		role.setRoleName(dto.getRoleName());
		return role;
	}

	@Override
	public RoleDTO update(RoleDTO dto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Role> deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public RoleDTO getById(Integer roleId) {
		// TODO Auto-generated method stub
		if (roleDAO.findById(roleId).isPresent()) {
			final Role userBeans = roleDAO.findById(roleId).get();
			return convertDomainToDto(userBeans);
		} else {
			return null;
		}
	}
}
