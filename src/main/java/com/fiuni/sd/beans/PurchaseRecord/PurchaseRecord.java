package com.fiuni.sd.beans.PurchaseRecord;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fiuni.sd.beans.Base.BaseBean;

import javax.persistence.Id;

//registro de compras
@Entity
@Table(name = "PurchaseRecords")
public class PurchaseRecord implements BaseBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_Record_Id", nullable = false, unique = true)
	private Integer purchaseRecordsId;

	@Column(name = "record_date")
	private Date date;

	@Column(name = "final_Price")
	private Integer finalPrice;

	@OneToMany(mappedBy = "purchaseRecord")
	private Set<PurchaseRecordDetail> purchaseRecordDetails = new HashSet<>();

	public Set<PurchaseRecordDetail> get_purchaseRecordDetails() {
		return purchaseRecordDetails;
	}

	public void set_purchaseRecordDetails(Set<PurchaseRecordDetail> purchaseRecordDetails) {
		this.purchaseRecordDetails = purchaseRecordDetails;
	}

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

	public String toString() {
		return "purchaseRecords[id=" + purchaseRecordsId + ", date=" + date + ", finalPrice=" + finalPrice
				+ ", purchaseRecordDetails=" + purchaseRecordDetails + "]";
	}

}
