package com.real.interview.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope(scopeName = "prototype")
public class Prototype {

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
