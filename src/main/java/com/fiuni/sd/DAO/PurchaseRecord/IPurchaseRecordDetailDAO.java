package com.fiuni.sd.DAO.PurchaseRecord;

import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecordDetail;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseRecordDetailDAO extends CrudRepository<PurchaseRecordDetail, Integer> {

	public Page<PurchaseRecordDetail> findAll(Pageable pageable);
}
