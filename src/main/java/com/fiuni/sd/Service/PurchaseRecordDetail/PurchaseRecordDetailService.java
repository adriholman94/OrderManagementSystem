package com.fiuni.sd.Service.PurchaseRecordDetail;

import javax.transaction.Transactional;

import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecordDetail;
import com.fiuni.sd.DAO.PurchaseRecord.IPurchaseRecordDetailDAO;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailDTO;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Service.Product.ProductService;
import com.fiuni.sd.Service.PurchaseRecord.PurchaseRecordService;
import com.fiuni.sd.Service.Supplier.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRecordDetailService
        extends BaseServiceImpl<PurchaseRecordDetailDTO, PurchaseRecordDetail, PurchaseRecordDetailResult>
        implements IPurchaseRecordDetailService {

    @Autowired
    private IPurchaseRecordDetailDAO purchaseDetailDAO;

    @Override
    @Transactional
    public PurchaseRecordDetailDTO save(PurchaseRecordDetailDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public PurchaseRecordDetailDTO update(PurchaseRecordDetailDTO dto, Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRecordDetailResult getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRecordDetailDTO deleteById(Integer id) {
		PurchaseRecordDetailDTO roleBean = null;
		if (purchaseDetailDAO.existsById(id)) {
			roleBean = null;
			purchaseDetailDAO.deleteById(id);
		}
		return roleBean;
    }

    @Override
    public PurchaseRecordDetailDTO getById(Integer Id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRecordDetailDTO convertBeanToDto(PurchaseRecordDetail bean) {
        final PurchaseRecordDetailDTO DTO = new PurchaseRecordDetailDTO();
        DTO.setId(bean.getPurchaseRecordDetailId());
        DTO.setProduct(new ProductService().convertBeanToDto(bean.getProduct()));
        DTO.setSupplier(new SupplierService().convertBeanToDto(bean.getSupplier()));
        DTO.setProductQuantity(bean.getProductQuantity());
        DTO.setUnitPrice(bean.getUnitPrice());
        DTO.setTotalPrice(bean.getTotalPrice());
        DTO.setPurchaseRecord(new PurchaseRecordService().convertBeanToDto(bean.getPurchaseRecord()));
        return DTO;
    }

    @Override
    public PurchaseRecordDetail convertDtoToBean(PurchaseRecordDetailDTO dto) {
        final PurchaseRecordDetail bean = new PurchaseRecordDetail();
        bean.setPurchaseRecordDetailId(dto.getId());
        bean.setProduct(new ProductService().convertDtoToBean(dto.getProduct()));
        bean.setSupplier(new SupplierService().convertDtoToBean(dto.getSupplier()));
        bean.setProductQuantity(dto.getProductQuantity());
        bean.setUnitPrice(dto.getUnitPrice());
        bean.setTotalPrice(dto.getTotalPrice());
        bean.setPurchaseRecord(new PurchaseRecordService().convertDtoToBean(dto.getPurchaseRecord()));
        return bean;
    }

}
