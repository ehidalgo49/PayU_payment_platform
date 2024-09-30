package com.payu.payment_platform.application.core.service;

import com.payu.payment_platform.core.model.CreditCard;
import com.payu.payment_platform.core.model.Transaction;
import com.payu.payment_platform.core.port.AntiFraudPort;
import com.payu.payment_platform.core.port.BankPort;
import com.payu.payment_platform.core.service.PaymentService;
import com.payu.payment_platform.infrastructure.adapter.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("mock")
public class PaymentServiceTest {
    private BankPort bankPort;
    private AntiFraudPort antiFraudPort;
    private TransactionRepository transactionRepository;
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        bankPort = Mockito.mock(BankPort.class);
        antiFraudPort = Mockito.mock(AntiFraudPort.class);
        transactionRepository = Mockito.mock(TransactionRepository.class);
        paymentService = new PaymentService(bankPort, antiFraudPort, transactionRepository);
    }

    @Test
    void testProcessPaymentSuccess() {
        CreditCard creditCard = new CreditCard(1, "1234567890123456", "John Doe", "12/25", "123");
        Transaction transaction = new Transaction(null, creditCard, 100.0, "PENDING");

        Mockito.when(antiFraudPort.validateTransaction(transaction)).thenReturn(true);
        Mockito.when(bankPort.processPayment(transaction)).thenReturn(true);

        boolean result = paymentService.processPayment(transaction);

        assertTrue(result);
        Mockito.verify(transactionRepository).save(transaction);
    }
}
