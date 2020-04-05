package juc.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);  // ģ������ͣ��λ
        for (int i = 1; i <= 6; i++) {  // ģ��6������
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t������λ");
                    TimeUnit.SECONDS.sleep(2);   // ͣ��5��
                    System.out.println(Thread.currentThread().getName() + "\tͣ��5����뿪��λ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "Car " + i).start();
        }

    }
}
