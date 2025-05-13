package com.real.interview.theme;

import org.springframework.stereotype.Component;

@Component("darkCheckbox")
public class DarkCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("DarkCheckbox rendered");
    }
}
