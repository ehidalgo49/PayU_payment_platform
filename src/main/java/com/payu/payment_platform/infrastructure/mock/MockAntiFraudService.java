package com.payu.payment_platform.infrastructure.mock;

import com.payu.payment_platform.core.model.Transaction;
import com.payu.payment_platform.core.port.AntiFraudPort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mock")
public class MockAntiFraudService implements AntiFraudPort {
    @Override
    public boolean validateTransaction(Transaction transaction) {
        // Simulación del servicio antifraude
        return true;
    }
}
