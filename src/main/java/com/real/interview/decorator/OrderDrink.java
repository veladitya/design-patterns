package com.real.interview.decorator;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDrink {


    final ApplicationContext applicationContext;

    public OrderDrink(ApplicationContext context) {
        this.applicationContext = context;
    }

    public void orderDrink(List<String> layers) {
        Beverage drink = applicationContext.getBean(layers.get(0), Beverage.class);
        for (String layer : layers) {
            drink = (Beverage) applicationContext.getBean(layer, Beverage.class, drink);
        }
    }
}
