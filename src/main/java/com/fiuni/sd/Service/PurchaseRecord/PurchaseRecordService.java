package com.fiuni.sd.Service.PurchaseRecord;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecord;
import com.fiuni.sd.DAO.PurchaseRecord.IPurchaseRecordDAO;
import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordDTO;
import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordResult;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailDTO;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Service.PurchaseRecordDetail.PurchaseRecordDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRecordService extends BaseServiceImpl<PurchaseRecordDTO, PurchaseRecord, PurchaseRecordResult> implements IPurchaseRecordService {

	@Autowired
	private IPurchaseRecordDAO purchaseDAO;

	@Override
	@Transactional
	public PurchaseRecordDTO save(PurchaseRecordDTO dto) {
		final PurchaseRecord roleBean = new PurchaseRecord();
		final PurchaseRecord role = purchaseDAO.save(roleBean);
		return convertBeanToDto(role);
	}

	@Override
	@Transactional
	public PurchaseRecordResult getAll(Pageable pageable) {
		final List<PurchaseRecordDTO> purchases = new ArrayList<>();
		Page<PurchaseRecord> results = purchaseDAO.findAll(pageable);
		results.forEach(purchase-> purchases.add(convertBeanToDto(purchase)));
		final PurchaseRecordResult purchaseResult = new PurchaseRecordResult();
		purchaseResult.setPurchaseRecord(purchases);
		return purchaseResult;
	}

	@Override
	public PurchaseRecordDTO convertBeanToDto(PurchaseRecord bean) {
        final PurchaseRecordDTO DTO = new PurchaseRecordDTO();
		DTO.setId(bean.getPurchaseRecordsId());
		DTO.setDate(bean.getDate());
		DTO.setFinalPrice(bean.getFinalPrice());
		List<PurchaseRecordDetailDTO> details = new ArrayList<>();
		bean.get_purchaseRecordDetails().forEach(detail -> details.add(new PurchaseRecordDetailService().convertBeanToDto(detail)));
		DTO.setRoles(details);
		return DTO;
	}

	@Override
	protected PurchaseRecord convertDtoToBean(PurchaseRecordDTO DTO) {
        final PurchaseRecord bean = new PurchaseRecord();
		bean.setPurchaseRecordsId(DTO.getId());
		bean.setDate(DTO.getDate());
		bean.setFinalPrice(DTO.getFinalPrice());
		return bean;
	}

	@Override
	@Transactional
	public PurchaseRecordDTO update(PurchaseRecordDTO DTO, Integer id) {
		if (purchaseDAO.findById(id).isPresent()) {
            PurchaseRecord bean = purchaseDAO.findById(id).get();
			bean.setPurchaseRecordsId(DTO.getId());
			bean.setDate(DTO.getDate());
			bean.setFinalPrice(DTO.getFinalPrice());
			PurchaseRecord updatedRole = purchaseDAO.save(bean);
			return convertBeanToDto(updatedRole);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public PurchaseRecordDTO deleteById(Integer id) {
		PurchaseRecordDTO roleBean = null;
		if (purchaseDAO.existsById(id)) {
			roleBean = null;
			purchaseDAO.deleteById(id);
		}
		return roleBean;
	}

	@Override
	public PurchaseRecordDTO getById(Integer id) {
		if (purchaseDAO.findById(id).isPresent()) {
			final PurchaseRecord roleBeans = purchaseDAO.findById(id).get();
			return convertBeanToDto(roleBeans);
		} else {
			return null;
		}
	}
}
