package com.fiuni.sd.Service.PurchaseRecord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecord;
import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecordDetail;
import com.fiuni.sd.DAO.PurchaseRecord.IPurchaseRecordDAO;
import com.fiuni.sd.DAO.PurchaseRecord.IPurchaseRecordDetailDAO;
import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordDTO;
import com.fiuni.sd.DTO.PurchaseRecord.PurchaseRecordResult;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailDTO;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Service.Product.ProductService;
import com.fiuni.sd.Service.Supplier.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRecordService extends BaseServiceImpl<PurchaseRecordDTO, PurchaseRecord, PurchaseRecordResult>
		implements IPurchaseRecordService {

	@Autowired
	private IPurchaseRecordDAO purchaseDAO;

	@Autowired
	private IPurchaseRecordDetailDAO purchaseDetailDAO;

	@Override
	@Transactional
	public PurchaseRecordDTO save(PurchaseRecordDTO DTO) {
		final PurchaseRecord purchase = new PurchaseRecord();
		purchase.setDate(DTO.getDate());
		purchase.setFinalPrice(DTO.getFinalPrice());

		final PurchaseRecord savedPurchase = purchaseDAO.save(purchase);

		final Set<PurchaseRecordDetail> details = new HashSet<PurchaseRecordDetail>();
		if (DTO.getPurchaseRecordDetails() != null) {
			for (PurchaseRecordDetailDTO detail : DTO.getPurchaseRecordDetails()) {
				
				PurchaseRecordDetail saveBean = new PurchaseRecordDetail();
				
				saveBean.setProduct(new ProductService().convertDtoToBean(detail.getProduct()));
				saveBean.setSupplier(new SupplierService().convertDtoToBean(detail.getSupplier()));
				saveBean.setUnitPrice(detail.getUnitPrice());
				saveBean.setProductQuantity(detail.getProductQuantity());
				saveBean.setPurchaseRecord(savedPurchase);
				
				final PurchaseRecordDetail detailBean = purchaseDetailDAO.save(saveBean);

				/*PurchaseRecordDetailDTO savedDTO = new PurchaseRecordDetailDTO();
				
				savedDTO.setId(detailBean.getPurchaseRecordDetailId());
				savedDTO.setProduct(new ProductService().convertBeanToDto(detailBean.getProduct()));
				savedDTO.setSupplier(new SupplierService().convertBeanToDto(detailBean.getSupplier()));
				savedDTO.setUnitPrice(detailBean.getUnitPrice());
				savedDTO.setProductQuantity(detailBean.getProductQuantity());
				savedDTO.setPurchaseRecord(detailBean.getPurchaseRecord().getPurchaseRecordsId());
				*/
				details.add(detailBean);
			}
		}
		savedPurchase.setPurchaseRecordDetails(details);
		final PurchaseRecordDTO purchaseDTO = convertBeanToDto(savedPurchase);
		return purchaseDTO;
	}

	@Override
	@Transactional
	public PurchaseRecordResult getAll(Pageable pageable) {
		final List<PurchaseRecordDTO> purchases = new ArrayList<>();
		Page<PurchaseRecord> results = purchaseDAO.findAll(pageable);
		results.forEach(purchase -> purchases.add(convertBeanToDto(purchase)));
		final PurchaseRecordResult purchaseResult = new PurchaseRecordResult();
		purchaseResult.setPurchaseRecord(purchases);
		purchaseResult.setPages(results.getTotalPages());
		return purchaseResult;
	}

	@Override
	public PurchaseRecordDTO convertBeanToDto(PurchaseRecord bean) {
		final PurchaseRecordDTO DTO = new PurchaseRecordDTO();
		DTO.setId(bean.getPurchaseRecordsId());
		DTO.setDate(bean.getDate());
		DTO.setFinalPrice(bean.getFinalPrice());
		List<PurchaseRecordDetailDTO> d = new ArrayList<>();
		bean.getPurchaseRecordDetails().forEach(detail -> d.add(convertBeanToDto(detail)));
		DTO.setPurchaseRecordDetails(d);
		return DTO;
	}

	@Override
	public PurchaseRecord convertDtoToBean(PurchaseRecordDTO DTO) {
		final PurchaseRecord bean = new PurchaseRecord();
		bean.setPurchaseRecordsId(DTO.getId());
		bean.setDate(DTO.getDate());
		bean.setFinalPrice(DTO.getFinalPrice());
		Set<PurchaseRecordDetail> d = new HashSet<>();
		DTO.getPurchaseRecordDetails().forEach(detail -> d.add(convertDtoToBean(detail)));
		bean.setPurchaseRecordDetails(d);
		return bean;
	}

	@Override
	@Transactional
	public PurchaseRecordDTO update(PurchaseRecordDTO DTO, Integer id) {
		if (purchaseDAO.findById(id).isPresent()) {
			if (DTO.getPurchaseRecordDetails() == null) {
				DTO.setPurchaseRecordDetails(new ArrayList<>());
			}
			PurchaseRecord bean = purchaseDAO.save(convertDtoToBean(DTO));
			final List<PurchaseRecordDetail> dbList = purchaseDetailDAO.findByPurchaseRecord(bean);
			final List<PurchaseRecordDetailDTO> dbupdate = new ArrayList<>();
			final List<PurchaseRecordDetailDTO> dbsave = new ArrayList<>();
			final List<PurchaseRecordDetailDTO> dbdelete = new ArrayList<>();
			final List<PurchaseRecordDetailDTO> detailsDTO = new ArrayList<>();

			DTO.getPurchaseRecordDetails().forEach(detail -> {
				if (detail.getId() == null) {
					dbsave.add(detail);
				} else {
					dbupdate.add(detail);
				}
			});

			for (PurchaseRecordDetail beans : dbList) {
				boolean isthere = false;
				for (PurchaseRecordDetailDTO dtos : DTO.getPurchaseRecordDetails()) {
					if (dtos.getId() == beans.getPurchaseRecordDetailId()) {
						isthere = true;
					}
				}
				if (!isthere) {
					dbdelete.add(convertBeanToDto(beans));
				}
			}

			for (PurchaseRecordDetailDTO s : dbsave) {
				s.setPurchaseRecord(DTO.getId());
				final PurchaseRecordDetail detailBean = purchaseDetailDAO
						.save(convertDtoToBean(s));
				detailsDTO.add(convertBeanToDto(detailBean));
			}

			for (PurchaseRecordDetailDTO s : dbdelete) {
				purchaseDetailDAO.deleteById(s.getId());
			}

			dbupdate.forEach(update -> {
				final PurchaseRecordDetail detailBean = purchaseDetailDAO
						.save(convertDtoToBean(update));
				detailsDTO.add(convertBeanToDto(detailBean));
			});

			final PurchaseRecordDTO updatedDTO = convertBeanToDto(bean);
			updatedDTO.setPurchaseRecordDetails(detailsDTO);
			return updatedDTO;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public PurchaseRecordDTO deleteById(Integer id) {
		PurchaseRecordDTO bean = null;
		if (purchaseDAO.existsById(id)) {
			bean = convertBeanToDto(purchaseDAO.findById(id).get());
			purchaseDAO.deleteById(id);
		}
		return bean;
	}

	@Override
	public PurchaseRecordDTO getById(Integer id) {
		if (purchaseDAO.findById(id).isPresent()) {
			final PurchaseRecord bean = purchaseDAO.findById(id).get();
			final PurchaseRecordDTO DTO = convertBeanToDto(bean);
			List<PurchaseRecordDetailDTO> details = new ArrayList<>();
			bean.getPurchaseRecordDetails().forEach(detail -> details.add(convertBeanToDto(detail)));
			DTO.setPurchaseRecordDetails(details);
			return DTO;
		} else {
			return null;
		}
	}

	public PurchaseRecordDetailDTO convertBeanToDto(PurchaseRecordDetail bean) {
        final PurchaseRecordDetailDTO DTO = new PurchaseRecordDetailDTO();
        DTO.setId(bean.getPurchaseRecordDetailId());
        DTO.setProduct(new ProductService().convertBeanToDto(bean.getProduct()));
        DTO.setSupplier(new SupplierService().convertBeanToDto(bean.getSupplier()));
        DTO.setProductQuantity(bean.getProductQuantity());
        DTO.setUnitPrice(bean.getUnitPrice());
        DTO.setTotalPrice(bean.getTotalPrice());
        DTO.setPurchaseRecord(bean.getPurchaseRecord().getPurchaseRecordsId());
        return DTO;
    }

    public PurchaseRecordDetail convertDtoToBean(PurchaseRecordDetailDTO dto) {
        final PurchaseRecordDetail bean = new PurchaseRecordDetail();
        bean.setPurchaseRecordDetailId(dto.getId());
        bean.setProduct(new ProductService().convertDtoToBean(dto.getProduct()));
        bean.setSupplier(new SupplierService().convertDtoToBean(dto.getSupplier()));
        bean.setProductQuantity(dto.getProductQuantity());
        bean.setUnitPrice(dto.getUnitPrice());
        bean.setTotalPrice(dto.getTotalPrice());
        bean.setPurchaseRecord(convertDtoToBean(getById(dto.getPurchaseRecord())));
        return bean;
    }
}
