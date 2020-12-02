package com.fiuni.sd.beans;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

//registro de compras
@Entity
@Table(name = "purchaseRecords")
public class PurchaseRecords {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer purchaseRecordsId;
	
		
	@Column(name = "date")
	private Date date;
	
	@Column(name = "finalPrice")
	private Integer	finalPrice;


	public Integer getPurchaseRecordsId() {
		return purchaseRecordsId;
	}
	public void setPurchaseRecordsId(Integer purchaseRecordsId) {
		this.purchaseRecordsId = purchaseRecordsId;
	}

public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Integer getFinalPrice() {
	return finalPrice;
}
public void setFinalPrice(Integer finalPrice) {
	this.finalPrice = finalPrice;
}


}
