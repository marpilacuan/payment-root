package com.pilacuan.payment.service;

import java.util.Optional;

import com.pilacuan.payment.entity.Account;
import com.pilacuan.payment.model.BalanceRequest;
import com.pilacuan.payment.model.BalanceResponse;

/**
 * Interface account service.
 * 
 * @author mpilacuan
 *
 */
public interface AccountService {

	/**
	 * Find account by account number.
	 * 
	 * @param accountNumber the account number
	 * @return account
	 */
	Optional<Account> findByAccountNumber(String accountNumber);

	/**
	 * Update balance.
	 * 
	 * @param request the request
	 * @return balance response
	 */
	BalanceResponse updateBalanceAccount(BalanceRequest request);

}
