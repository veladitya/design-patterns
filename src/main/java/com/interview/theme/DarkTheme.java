package com.interview.theme;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("darkTheme")
public class DarkTheme implements Theme {
    private final Button button;
    private final Checkbox checkbox;

    public DarkTheme(@Qualifier("darkButton") Button button, @Qualifier("darkCheckbox") Checkbox checkbox) {
        this.button = button;
        this.checkbox = checkbox;
    }

    @Override
    public void apply() {
        this.button.render();
        this.checkbox.render();
    }
}
