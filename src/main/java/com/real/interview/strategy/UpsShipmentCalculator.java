package com.real.interview.strategy;

import org.springframework.stereotype.Component;

@Component("ups")
public class UpsShipmentCalculator implements ShipmentCalculator {
    @Override
    public double calculate(Order order) {
        return 2;
    }
}
