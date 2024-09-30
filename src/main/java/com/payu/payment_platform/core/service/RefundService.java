package com.payu.payment_platform.core.service;

import com.payu.payment_platform.core.model.Transaction;
import com.payu.payment_platform.core.port.BankPort;
import com.payu.payment_platform.infrastructure.adapter.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Este servicio maneja la lógica de reembolsos.
@Service
public class RefundService {
    private final BankPort bankPort;
    private final TransactionRepository transactionRepository;

    public RefundService(BankPort bankPort, TransactionRepository transactionRepository) {
        this.bankPort = bankPort;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public boolean processRefund(Transaction transaction) {
        // Lógica para reembolsar una transacción, por ejemplo, cambiar su estado
        Optional<Transaction> transOpt = transactionRepository.findById(Long.valueOf(transaction.getTransactionId()));
        if (transOpt.isPresent()) {
            transaction = transOpt.get();
            boolean paymentSuccess = bankPort.processRefund(transaction);
            transaction.setStatus("REFOUND_SUCCESS");
            transactionRepository.save(transaction);
            return paymentSuccess;
        }
        return false;
    }
}
