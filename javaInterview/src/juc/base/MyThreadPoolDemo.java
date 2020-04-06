package juc.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳�
 * Arrays
 * Collections
 * Executors
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        List list1 = Arrays.asList('a','b');
        //�̶������̳߳أ�һ�����߳�

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);// һ�����߳�
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();  //  һ��һ�߳�
        ExecutorService threadPool = Executors.newCachedThreadPool();  //  n��n�߳�

        // 10���ͻ��������ҵ��
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t����ҵ��");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
