package com.real.interview.theme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThemeApplication {

    @Value("${theme.name:lightTheme}")
    private String themeName;

    private final ThemeFactory themeFactory;

    public ThemeApplication(ThemeFactory themeFactory) {
        this.themeFactory = themeFactory;
    }

    public void applyTheme() {
        this.themeFactory.theme(themeName).apply();
    }
}
