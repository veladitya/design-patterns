package com.interview.adapter;

public interface PaymentProcessor {
    /**
     * Charge the customer the given amount (in dollars).
     */
    void processPayment(double amount);
}
