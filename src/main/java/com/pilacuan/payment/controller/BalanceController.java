package com.pilacuan.payment.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilacuan.payment.model.BalanceRequest;
import com.pilacuan.payment.model.BalanceResponse;
import com.pilacuan.payment.service.AccountService;

/**
 * Controller balance.
 * 
 * @author mpilacuan
 *
 */
@RestController
@CrossOrigin()
public class BalanceController {

	@Autowired
	AccountService accountService;

	/**
	 * Generate transaction.
	 * 
	 * @param request the request
	 * @return balance response
	 */
	@RequestMapping({ "/balanceTransaction" })
	@Transactional
	public BalanceResponse generateTransaction(BalanceRequest request) {
		return this.accountService.updateBalanceAccount(request);
	}

}
