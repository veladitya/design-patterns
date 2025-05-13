package com.real.interview.observer;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void updateOrderStatus(String orderId, String newStatus) {
        this.publisher.publishEvent(new OrderStatusEventChanged(this, orderId, newStatus));
    }
}
