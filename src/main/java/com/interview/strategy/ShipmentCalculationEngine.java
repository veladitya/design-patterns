package com.interview.strategy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ShipmentCalculationEngine {

    private final Map<String, ShipmentCalculator> shipmentCalculators;

    ShipmentCalculationEngine(Map<String, ShipmentCalculator> shipmentCalculators) {
        this.shipmentCalculators = shipmentCalculators;
    }

    public double getShipmentCost(String context, Order order) {
        return shipmentCalculators.get(context).calculate(order);
    }
}
