package com.interview.facade;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Payment processed" + amount);
        return true;
    }
}
