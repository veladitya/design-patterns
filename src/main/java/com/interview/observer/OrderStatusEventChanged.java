package com.interview.observer;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderStatusEventChanged extends ApplicationEvent {

    private final String orderId;
    private final String status;

    public OrderStatusEventChanged(Object source, String orderId, String newStatus) {
        super(source);
        this.orderId = orderId;
        this.status = newStatus;
    }

}
