package com.interview.theme;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ThemeFactory {

    private final Map<String, Theme> themes;

    public ThemeFactory(Map<String, Theme> themes) {
        this.themes = themes;
    }

    public Theme theme(String themeName) {
        return themes.get(themeName);
    }
}
