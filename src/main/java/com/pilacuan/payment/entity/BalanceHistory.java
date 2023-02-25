package com.pilacuan.payment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Balance history.
 * 
 * @author mpilacuan
 *
 */
@Entity
@Table(name = "TB_BALANCE_HISTORY")
public class BalanceHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_balance_history")
	private Long idBalanceHistory;

	@Column(name = "id_account_origin")
	private Long idAccountOrigin;

	@Column(name = "id_account_destination")
	private Long idAccountDestination;

	@Column(name = "value_transaction")
	private Double valueTransaction;

	@Column(name = "number_transaction")
	private String numberTransaction;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private Date modifiedDate;

	public Long getIdBalanceHistory() {
		return idBalanceHistory;
	}

	public void setIdBalanceHistory(Long idBalanceHistory) {
		this.idBalanceHistory = idBalanceHistory;
	}

	public Long getIdAccountOrigin() {
		return idAccountOrigin;
	}

	public void setIdAccountOrigin(Long idAccountOrigin) {
		this.idAccountOrigin = idAccountOrigin;
	}

	public Long getIdAccountDestination() {
		return idAccountDestination;
	}

	public void setIdAccountDestination(Long idAccountDestination) {
		this.idAccountDestination = idAccountDestination;
	}

	public Double getValueTransaction() {
		return valueTransaction;
	}

	public void setValueTransaction(Double valueTransaction) {
		this.valueTransaction = valueTransaction;
	}

	public String getNumberTransaction() {
		return numberTransaction;
	}

	public void setNumberTransaction(String numberTransaction) {
		this.numberTransaction = numberTransaction;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
}
