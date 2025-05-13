package com.real.interview.decorator;

import org.springframework.stereotype.Component;

@Component("Mocha")
public class Mocha implements Beverage {

    private final Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.0;
    }
}
