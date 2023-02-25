package com.pilacuan.payment.model;


/**
 * Balance response.
 * 
 * @author mpilacuan
 *
 */

public class BalanceResponse {

	private String transactionNumber;
	private AccountResponse accountOrigin;
	private AccountResponse accountDestination;

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public AccountResponse getAccountOrigin() {
		return accountOrigin;
	}

	public void setAccountOrigin(AccountResponse accountOrigin) {
		this.accountOrigin = accountOrigin;
	}

	public AccountResponse getAccountDestination() {
		return accountDestination;
	}

	public void setAccountDestination(AccountResponse accountDestination) {
		this.accountDestination = accountDestination;
	}

}
