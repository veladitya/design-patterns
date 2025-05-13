package com.real.interview.services;

import com.real.interview.components.Prototype;
import com.real.interview.components.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignService {

    @Autowired
    private Prototype prototype;

    @Autowired
    private Singleton singleton;

    public void run() {
        prototype.add("3", "3");
        prototype.add("4", "4");
        singleton.add("3", "3");
        singleton.add("4", "4");
    }

    public void getCache() {
        System.out.println("Singleton: " + singleton.getCache());
        System.out.println("Prototype: " + prototype.getCache());
    }
}
