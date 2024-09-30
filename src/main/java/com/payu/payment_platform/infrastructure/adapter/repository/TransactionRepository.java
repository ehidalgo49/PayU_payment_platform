package com.payu.payment_platform.infrastructure.adapter.repository;

import com.payu.payment_platform.core.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}