package com.interview.theme;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lightTheme")
public class LightTheme implements Theme {

    private final Button button;
    private final Checkbox checkbox;

    public LightTheme(@Qualifier("lightButton") Button button, @Qualifier("lightCheckbox") Checkbox checkbox) {
        this.button = button;
        this.checkbox = checkbox;
    }

    @Override
    public void apply() {
        this.button.render();
        this.checkbox.render();
    }
}
