package com.interview.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailEventListener {

    @EventListener
    public void sendEmail(OrderStatusEventChanged event) {
        System.out.printf("Email: Order %s is now %s%n", event.getOrderId(), event.getStatus());
    }
}
