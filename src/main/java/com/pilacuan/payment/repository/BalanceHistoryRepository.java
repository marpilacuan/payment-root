package com.pilacuan.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilacuan.payment.entity.BalanceHistory;

/**
 * Balance history repository.
 * 
 * @author mpilacuan
 *
 */
public interface BalanceHistoryRepository extends JpaRepository<BalanceHistory, Long> {

}
