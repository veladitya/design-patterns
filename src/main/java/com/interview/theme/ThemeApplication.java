package com.interview.theme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThemeApplication {

    private final ThemeFactory themeFactory;
    @Value("${theme.name:lightTheme}")
    private String themeName;

    public ThemeApplication(ThemeFactory themeFactory) {
        this.themeFactory = themeFactory;
    }

    public void applyTheme() {
        this.themeFactory.theme(themeName).apply();
    }
}
