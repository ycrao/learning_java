package com.raoyc.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class OddNumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class EvenNumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
public class ThreadPoolTest {

    public static void main(String[] args) {
        // fixed-size thread pool
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass());

        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        // 1. define props
        // service1.setCorePoolSize(15);
        // service1.setKeepAliveTime();

        // 2. execute thread operation
        service.execute(new OddNumberThread());
        service.execute(new EvenNumberThread());

        // 3. close pool
        service.shutdown();
    }
}
