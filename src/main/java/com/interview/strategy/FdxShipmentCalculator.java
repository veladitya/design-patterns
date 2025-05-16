package com.interview.strategy;

import org.springframework.stereotype.Component;

@Component("fedex")
public class FdxShipmentCalculator implements ShipmentCalculator {
    @Override
    public double calculate(Order order) {
        return 1;
    }
}
