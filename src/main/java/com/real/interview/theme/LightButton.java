package com.real.interview.theme;

import org.springframework.stereotype.Component;

@Component("lightButton")
public class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("LightButton rendered");
    }
}
