package com.interview.decorator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("baseDrink")
@Primary
public class BaseDrink implements Beverage {
    @Override
    public String getDescription() {
        return "BaseDrink";
    }

    @Override
    public double cost() {
        return 10.0;
    }
}
