package com.payu.payment_platform.core.service;

import com.payu.payment_platform.core.model.Transaction;
import com.payu.payment_platform.core.port.AntiFraudPort;
import com.payu.payment_platform.core.port.BankPort;
import com.payu.payment_platform.infrastructure.adapter.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Este servicio maneja la lógica de procesamiento de pagos
@Service
public class PaymentService {
    private final BankPort bankPort;
    private final AntiFraudPort antiFraudPort;

    private final TransactionRepository transactionRepository;

    public PaymentService(BankPort bankPort, AntiFraudPort antiFraudPort, TransactionRepository transactionRepository) {
        this.bankPort = bankPort;
        this.antiFraudPort = antiFraudPort;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public boolean processPayment(Transaction transaction) {
        if (antiFraudPort.validateTransaction(transaction)) {
            boolean paymentSuccess = bankPort.processPayment(transaction);
            transaction.setStatus(paymentSuccess ? "SUCCESS" : "FAILED");
            transactionRepository.save(transaction);  // Guardar la transacción en la base de datos
            return paymentSuccess;
        }
        transaction.setStatus("FAILED_ANTI_FRAUD");
        transactionRepository.save(transaction);  // Guardar la transacción fallida
        return false;
    }
}
