package com.pilacuan.payment.service.impl;

import java.util.Date;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pilacuan.payment.entity.Account;
import com.pilacuan.payment.entity.BalanceHistory;
import com.pilacuan.payment.model.AccountResponse;
import com.pilacuan.payment.model.BalanceRequest;
import com.pilacuan.payment.model.BalanceResponse;
import com.pilacuan.payment.repository.AccountRepository;
import com.pilacuan.payment.repository.BalanceHistoryRepository;
import com.pilacuan.payment.service.AccountService;

@Service
@Lazy
public class AccountServiceImpl implements AccountService {

	@Value("${jwt.secret}")
	private String userName;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BalanceHistoryRepository balanceHistoryRepository;

	@Override
	public Optional<Account> findByAccountNumber(String accountNumber) {
		return this.accountRepository.findByAccountNumber(accountNumber);

	}

	@Override
	public BalanceResponse updateBalanceAccount(BalanceRequest request) {
		Optional<Account> accountOrigin = this.findByAccountNumber(request.getAccountOrigin());
		Optional<Account> accountDestination = this.findByAccountNumber(request.getAccountDestination());
		if (accountOrigin.isPresent() && accountDestination.isPresent()) {
			if (haveBalance(accountOrigin.get().getBalance(), request.getTotal())) {
				accountOrigin.get().setBalance(accountOrigin.get().getBalance() - request.getTotal());
				accountDestination.get().setBalance(accountDestination.get().getBalance() + request.getTotal());
				AccountResponse accountOriginUpdate = this.updateBalance(accountOrigin.get());
				AccountResponse accountDestinationUpdate = this.updateBalance(accountDestination.get());
				BalanceHistory balanceHistory = this.updateBalanceHistory(accountOrigin.get().getIdAccount(), accountDestination.get().getIdAccount(), request.getTotal());
				BalanceResponse response = new BalanceResponse();
				response.setAccountOrigin(accountOriginUpdate);
				response.setAccountDestination(accountDestinationUpdate);
				response.setTransactionNumber(balanceHistory.getNumberTransaction());

			}
		}

		return new BalanceResponse();
	}

	private Boolean haveBalance(Double balance, Double total) {
		return balance >= total ? Boolean.TRUE : Boolean.FALSE;

	}

	private AccountResponse updateBalance(Account account) {
		account.setModifiedBy(userName);
		account.setModifiedDate(new Date());
		Account accountUpdate = this.accountRepository.save(account);
		AccountResponse response = new AccountResponse();
		response.setAccoutNumeber(accountUpdate.getAccountNumber());
		response.setBalance(accountUpdate.getBalance());
		return response;
	}

	private int generateRandomNumber() {
		return (int)(Math.random() * (100000 + 1));
	}
	
	private BalanceHistory updateBalanceHistory(Long originId, Long destinationId, Double total) {
		BalanceHistory balanceHistory = new BalanceHistory();
		balanceHistory.setIdAccountOrigin(originId);
		balanceHistory.setIdAccountDestination(destinationId);
		balanceHistory.setValueTransaction(total);
		balanceHistory.setNumberTransaction(String.valueOf(generateRandomNumber()));
		return this.balanceHistoryRepository.save(balanceHistory);
	}
}
