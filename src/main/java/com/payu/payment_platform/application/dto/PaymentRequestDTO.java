package com.payu.payment_platform.application.dto;

import com.payu.payment_platform.core.model.CreditCard;
import com.payu.payment_platform.core.model.Transaction;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaymentRequestDTO {
    private Integer cardId;
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvv;
    private double amount;

    public Transaction toTransaction() {
        CreditCard creditCard = new CreditCard(cardId, cardNumber, cardHolder, expirationDate, cvv);
        return new Transaction(null, creditCard, amount, "PENDING");
    }
}
