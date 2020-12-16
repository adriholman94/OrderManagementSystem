package com.fiuni.sd.Service.Supplier;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fiuni.sd.Beans.Supplier.Supplier;
import com.fiuni.sd.DAO.Supplier.ISupplierDAO;
import com.fiuni.sd.DTO.Supplier.SupplierDTO;
import com.fiuni.sd.DTO.Supplier.SupplierResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;

@Service
public class SupplierService extends BaseServiceImpl<SupplierDTO, Supplier, SupplierResult> implements ISupplierService {

	@Autowired
	private ISupplierDAO supplierDAO;

	@Override
	@Transactional
	public SupplierDTO save(SupplierDTO dto) {
		final Supplier supplierBean = new Supplier();
		supplierBean.setSupplierName(dto.getSupplierName());
		final Supplier supplier = supplierDAO.save(supplierBean);
		return convertBeanToDto(supplier);
	}

	@Override
	@Transactional
	public SupplierResult getAll(Pageable pageable) {
		final List<SupplierDTO> suppliers = new ArrayList<>();
		Page<Supplier> results = supplierDAO.findAll(pageable);
		results.forEach(supplier -> suppliers.add(convertBeanToDto(supplier)));
		final SupplierResult supplierResult = new SupplierResult();
		supplierResult.setSupplier(suppliers);
		return supplierResult;
	}

	@Override
	public SupplierDTO convertBeanToDto(Supplier bean) {
		final SupplierDTO supplierDTO = new SupplierDTO();
		supplierDTO.setId(bean.getSupplierId());
		supplierDTO.setSupplierName(bean.getSupplierName());
		return supplierDTO;
	}

	@Override
	public Supplier convertDtoToBean(SupplierDTO dto) {
		final Supplier supplierBean = new Supplier();
		supplierBean.setSupplierId(dto.getId());
		supplierBean.setSupplierName(dto.getSupplierName());
		return supplierBean;
	}

	@Override
	@Transactional
	public SupplierDTO update(SupplierDTO dto, Integer id) {
		if (supplierDAO.findById(id).isPresent()) {
			Supplier supplierBean = supplierDAO.findById(id).get();
			supplierBean.setSupplierName(dto.getSupplierName());
			Supplier updatedSupplier = supplierDAO.save(supplierBean);
			return convertBeanToDto(updatedSupplier);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public SupplierDTO deleteById(Integer id) {
		SupplierDTO supplierBean = null;
		if (supplierDAO.existsById(id)) {
			supplierBean = null;
			supplierDAO.deleteById(id);

		}
		return supplierBean;
	}

	@Override
	public SupplierDTO getById(Integer id) {
		if (supplierDAO.findById(id).isPresent()) {
			final Supplier supplierBeans = supplierDAO.findById(id).get();
			return convertBeanToDto(supplierBeans);
		} else {
			return null;
		}
	}
}
