package com.payu.payment_platform.application.dto;

import com.payu.payment_platform.core.model.Transaction;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RefundRequestDTO {
    private Integer transactionId;
    private double amount;

    public Transaction toTransaction() {
        return new Transaction(transactionId, null, amount, "REFUND");
    }
}
