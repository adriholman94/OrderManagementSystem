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
		final Role roleBeans = convertDtoToBean(dto);
		final Role role = roleDAO.save(roleBeans);
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
	public RoleDTO update(RoleDTO dto,Integer id) {
		if (roleDAO.findById(id).isPresent()){
            Role roleBean = roleDAO.findById(id).get();
            roleBean.setRoleName(dto.getRoleName());
            
            Role updatedRole = roleDAO.save(roleBean);
            return convertBeanToDto(updatedRole);
        }else{
            return null;
        }
	}
	
	@Override
	@Transactional
	public Optional<Role> deleteById(Integer id){
		Optional<Role> roleBean = null;	
		if(roleDAO.existsById(id)) {
			roleBean = roleDAO.findById(id);
			roleDAO.deleteById(id);
		}
		return roleBean;
	}
  
	@Override
	@Transactional
	public RoleDTO getById(Integer roleId) {
		if (roleDAO.findById(roleId).isPresent()) {
			final Role roleBean = roleDAO.findById(roleId).get();
			return convertBeanToDto(roleBean);
		} else {
			return null;
		}
	}
}
