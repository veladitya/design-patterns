package com.interview.adapter;

import org.springframework.stereotype.Component;

@Component("AcmePayClient")
public class AcmePayClient {
    /**
     * Charge the customer using cents and a currency code.
     */
    public void pay(int amountInCents, String currencyCode) {
        System.out.println("AcmePayClient" + amountInCents + " " + currencyCode);
    }
}
