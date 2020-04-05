package juc.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��Ŀ��   ���������̣߳����Բ�����ʼֵΪ���һ������
 *     ʵ��һ���̶߳Ըñ�����1   һ���̶߳Ըñ�����1��
 *     ʵ�ֽ���  ��10�֣� ������ʼֵΪ��
 *
 * 1    ��������
 * 2    �ж�/�ɻ�/֪ͨ
 * 3    ���߳̽����У�����Ҫ��ֹ���̵߳���ٻ��� ���ж�ֻ����while��������if��
 */

// Synchronized �汾
//class AirConditioner {   // ��Դ��
//    private int number = 0;
//
//
//    public synchronized void increment() throws InterruptedException {
//        // 1  �ж�
//        while (number != 0) {  // ���߳̽����У�����Ҫ��ֹ���̵߳���ٻ��� �����if�ͻ���ּӻ���
//            this.wait();
//        }
//        // 2 �ɻ�
//        number++;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        // 3 ֪ͨ
//        this.notifyAll();
//    }
//
//    public synchronized void decrement() throws InterruptedException {
//        while (number == 0) {
//            this.wait();
//        }
//        number--;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        this.notifyAll();
//    }
//}

// ReentrantLock �汾
class AirConditioner {
    private int number = 0;
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            // 1  �ж�
            while (number != 0) {  // ���߳̽����У�����Ҫ��ֹ���̵߳���ٻ��� �����if�ͻ���ּӻ���
                condition.await();  // �ȼ��� this.wait();
            }
            // 2 �ɻ�
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3 ֪ͨ
            condition.signalAll();  // �ȼ���this.notifyAll()
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {
       lock.lock();
       try {
           while (number == 0) {
               condition.await();
           }
           number--;
           System.out.println(Thread.currentThread().getName() + "\t" + number);
           condition.signalAll();  // �ȼ���this.notifyAll()
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           lock.unlock();
       }
    }
}

public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {

                    airConditioner.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {

                    airConditioner.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
