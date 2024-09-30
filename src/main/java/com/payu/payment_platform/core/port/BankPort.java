package com.payu.payment_platform.core.port;

import com.payu.payment_platform.core.model.Transaction;

public interface BankPort {
    boolean processPayment(Transaction transaction);
    boolean processRefund(Transaction transaction);
}
