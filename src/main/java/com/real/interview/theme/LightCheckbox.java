package com.real.interview.theme;

import org.springframework.stereotype.Component;

@Component("lightCheckbox")
public class LightCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("LightCheckbox rendered");
    }
}
