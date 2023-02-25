package com.pilacuan.payment.model;

/**
 * Balance request.
 * 
 * @author mpilacuan
 *
 */
public class BalanceRequest {

	private String accountOrigin;
	private String accountDestination;
	private Double total;
	public String getAccountOrigin() {
		return accountOrigin;
	}
	public void setAccountOrigin(String accountOrigin) {
		this.accountOrigin = accountOrigin;
	}
	public String getAccountDestination() {
		return accountDestination;
	}
	public void setAccountDestination(String accountDestination) {
		this.accountDestination = accountDestination;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	
}
