package com.payu.payment_platform.infrastructure.adapter.bank;

import com.payu.payment_platform.core.model.Transaction;
import com.payu.payment_platform.core.port.BankPort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Implementación del puerto para comunicarse con el servicio bancario.
@Component
@Profile("prod")
public class BankServiceAdapter implements BankPort {

    private final RestTemplate restTemplate;
    private final String bankServiceUrl = "http://mock-bank-service"; // URL del servicio bancario

    public BankServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean processPayment(Transaction transaction) {
        // Aquí se haría la llamada al servicio bancario
        return restTemplate.postForObject(bankServiceUrl + "/payment", transaction.getTransactionId(), Boolean.class);
    }

    @Override
    public boolean processRefund(Transaction transaction) {
        // Lógica para invocar al servicio de reembolso
        return restTemplate.postForObject(bankServiceUrl + "/refound", transaction.getTransactionId(), Boolean.class);
    }


}
