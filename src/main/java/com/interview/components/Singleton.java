package com.interview.components;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Singleton {

    private final Map<String, String> singletonMap = new ConcurrentHashMap<>();

    public String getSingletonMap(String key) {
        return singletonMap.get(key);
    }

    public void add(final String key, final String value) {
        singletonMap.put(key, value);
    }

    public Map<String, String> getCache() {
        return singletonMap;
    }
}
