package javabase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        service.execute(new NumberThread());
        System.out.println("*************************");
        service.execute(new NumberThread());
        System.out.println("=============================");
        service.execute(new NumberThread1());
        System.out.println("*************************");
        service.execute(new NumberThread1());

        service.shutdown();
    }
}
