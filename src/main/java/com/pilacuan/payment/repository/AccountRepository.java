package com.pilacuan.payment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pilacuan.payment.entity.Account;

/**
 * Account repository.
 * 
 * @author mpilacuan
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	/**
	 * Find account by account number.
	 * 
	 * @param accountNumber the account number
	 * @return account
	 */
	@Query("SELECT u FROM Account u WHERE u.accountNumber = ?1")
	Optional<Account> findByAccountNumber(String accountNumber);
}
