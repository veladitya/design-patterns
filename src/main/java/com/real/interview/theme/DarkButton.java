package com.real.interview.theme;

import org.springframework.stereotype.Component;

@Component("darkButton")
public class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("DarkButton rendered");
    }
}
