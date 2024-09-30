package com.payu.payment_platform.application.controller;

import com.payu.payment_platform.application.dto.PaymentRequestDTO;
import com.payu.payment_platform.application.dto.RefundRequestDTO;
import com.payu.payment_platform.core.service.PaymentService;
import com.payu.payment_platform.core.service.RefundService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Expone las API para procesar pagos y reembolsos.
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final RefundService refundService;

    public PaymentController(PaymentService paymentService, RefundService refundService) {
        this.paymentService = paymentService;
        this.refundService = refundService;
    }

    @PostMapping
    public String processPayment(@RequestBody PaymentRequestDTO request) {
        // Mapea DTO a Transaction, llama a PaymentService
        return paymentService.processPayment(request.toTransaction()) ? "Payment successful" : "Payment failed";
    }

    @PostMapping("/refund")
    public String processRefund(@RequestBody RefundRequestDTO request) {
        // Mapea DTO a Transaction, llama a RefundService
        return refundService.processRefund(request.toTransaction()) ? "Refund successful" : "Refund failed";
    }
}
