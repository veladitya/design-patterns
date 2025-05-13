package com.real.interview.decorator;

import org.springframework.stereotype.Component;

@Component("Milk")
public class Milk implements Beverage {

    private final Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.0;
    }
}
