package juc.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * Arrays
 * Collections
 * Executors
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        List list1 = Arrays.asList('a','b');
        //固定数的线程池，一池五线程

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);// 一池五线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();  //  一池一线程
        ExecutorService threadPool = Executors.newCachedThreadPool();  //  n池n线程

        // 10个客户请求办理业务
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
