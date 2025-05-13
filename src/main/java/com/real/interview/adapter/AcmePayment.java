package com.real.interview.adapter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AcmePayment implements PaymentProcessor{

    private final AcmePayClient acmePayClient;

    public AcmePayment(@Qualifier("AcmePayClient") AcmePayClient acmePayClient, @Value("${payment.currency:USD}") String currencyCode) {
        this.acmePayClient = acmePayClient;
    }

    @Override
    public void processPayment(double amount) {
        acmePayClient.pay(12, "USD");
    }
}
