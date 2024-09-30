package com.payu.payment_platform.core.port;

import com.payu.payment_platform.core.model.Transaction;

public interface AntiFraudPort {
    boolean validateTransaction(Transaction transaction);
}
