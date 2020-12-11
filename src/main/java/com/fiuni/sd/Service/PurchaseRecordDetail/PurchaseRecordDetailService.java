package com.fiuni.sd.Service.PurchaseRecordDetail;

import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecordDetail;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailDTO;
import com.fiuni.sd.DTO.PurchaseRecordDetails.PurchaseRecordDetailResult;
import com.fiuni.sd.Service.Base.BaseServiceImpl;
import com.fiuni.sd.Service.Product.ProductService;
import com.fiuni.sd.Service.Supplier.SupplierService;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRecordDetailService
        extends BaseServiceImpl<PurchaseRecordDetailDTO, PurchaseRecordDetail, PurchaseRecordDetailResult>
        implements IPurchaseRecordDetailService {

    @Override
    public PurchaseRecordDetailDTO save(PurchaseRecordDetailDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
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
        // TODO Auto-generated method stub
        return null;
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
		return DTO;
	}

    @Override
    protected PurchaseRecordDetail convertDtoToBean(PurchaseRecordDetailDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
