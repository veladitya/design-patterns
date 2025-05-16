package com.interview.threads;

import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SampleThread {

    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public void threadPool() {
        threadPool.execute(new Runnable() {
            public void run() {
            }
        });

        threadPool.submit(new Callable<Object>() {
            public Object call() throws Exception {
                return null;
            }
        });
        threadPool.shutdown();
    }
}
