package com.payu.payment_platform.infrastructure.mock;

import com.payu.payment_platform.core.model.Transaction;
import com.payu.payment_platform.core.port.BankPort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mock")
public class MockBankService implements BankPort {
    @Override
    public boolean processPayment(Transaction transaction) {
        // Simular respuesta de banco
        return true;
    }

    @Override
    public boolean processRefund(Transaction transaction) {
        // Simular respuesta de reembolso bancario
        return true;
    }
}
