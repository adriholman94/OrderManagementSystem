package com.fiuni.sd.DAO.PurchaseRecord;


import com.fiuni.sd.Beans.PurchaseRecord.PurchaseRecord;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseRecordDAO extends CrudRepository<PurchaseRecord, Integer> {

	public Page<PurchaseRecord> findAll(Pageable pageable);
}
