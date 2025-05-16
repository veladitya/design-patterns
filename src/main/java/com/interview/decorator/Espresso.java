package com.interview.decorator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Espresso")
@Scope("prototype")
public class Espresso implements Beverage {

    private final Beverage beverage;

    public Espresso(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.0;
    }
}
