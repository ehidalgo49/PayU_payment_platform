package com.payu.payment_platform.infrastructure.adapter.antifraud;

import com.payu.payment_platform.core.model.Transaction;
import com.payu.payment_platform.core.port.AntiFraudPort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Implementación del puerto para conectarse al servicio antifraude.

@Component
@Profile("prod")
public class AntiFraudServiceAdapter implements AntiFraudPort {

    private final RestTemplate restTemplate;
    private final String antiFraudServiceUrl = "http://mock-anti-fraud-service";

    public AntiFraudServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean validateTransaction(Transaction transaction) {
        return restTemplate.getForObject(antiFraudServiceUrl + "/validate?info=" + transaction.getTransactionId(), Boolean.class);
    }
}
