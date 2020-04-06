package juc.base;

import java.util.concurrent.*;

/**
 * �̳߳�
 * Arrays
 * Collections
 * Executors
 */
public class MyThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService thredPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy(),
//                new ThreadPoolExecutor.CallerRunsPolicy(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        // 10 ���˿�����
        try {
            for (int i = 0; i < 10; i++) {
                thredPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t����ҵ��");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            thredPool.shutdown();
        }
    }
}

