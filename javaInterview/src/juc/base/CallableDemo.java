package juc.base;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();    // �������   ֻ�����һ��
        System.out.println(Thread.currentThread().getName() + "\t*********�������");
        System.out.println(futureTask.get());

    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("*********************come in here");
        // ��ͣһ���߳�
        TimeUnit.SECONDS.sleep(4);
        return 1024;
    }
}