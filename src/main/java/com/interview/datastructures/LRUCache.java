package com.interview.datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private final Map<String, String> cache;
    private final int capacity;
    private final LinkedList<String> list;

    LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        list = new LinkedList<>();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put("1", "1");
        cache.put("2", "2");
        System.out.println("1) " + cache.cache.keySet());
        cache.put("1", "1");
        System.out.println("2) " + cache.cache.keySet());
        cache.put("3", "3");
        System.out.println("3) " + cache.cache.keySet());
        cache.put("4", "4");
        System.out.println("4) " + cache.cache.keySet());

    }

    public String get(String key) {
        list.remove(key);
        list.addFirst(key);
        return cache.get(key);
    }

    public void put(String key, String value) {
        if (cache.size() >= capacity) {
            removeEldestEntry(value);
        }
        cache.put(key, value);
        list.addFirst(key);
    }

    private void removeEldestEntry(String value) {
        cache.remove(list.removeLast());
    }
}
