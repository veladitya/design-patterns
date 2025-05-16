package com.interview.facade;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShippingServiceimpl implements ShippingService {
    @Override
    public String processShipmentRequest() {
        return UUID.randomUUID().toString();
    }
}
