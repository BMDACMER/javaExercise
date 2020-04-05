package juc.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：   现在两个线程，可以操作初始值为玲的一个变量
 *     实现一个线程对该变量加1   一个线程对该变量减1，
 *     实现交替  来10轮， 变量初始值为零
 *
 * 1    高类聚耦合
 * 2    判断/干活/通知
 * 3    多线程交互中，必须要防止多线程的虚假唤醒 （判断只能用while，不能用if）
 */

// Synchronized 版本
//class AirConditioner {   // 资源类
//    private int number = 0;
//
//
//    public synchronized void increment() throws InterruptedException {
//        // 1  判断
//        while (number != 0) {  // 多线程交互中，必须要防止多线程的虚假唤醒 如果用if就会出现加唤醒
//            this.wait();
//        }
//        // 2 干活
//        number++;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        // 3 通知
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

// ReentrantLock 版本
class AirConditioner {
    private int number = 0;
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            // 1  判断
            while (number != 0) {  // 多线程交互中，必须要防止多线程的虚假唤醒 如果用if就会出现加唤醒
                condition.await();  // 等价于 this.wait();
            }
            // 2 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3 通知
            condition.signalAll();  // 等价于this.notifyAll()
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
           condition.signalAll();  // 等价于this.notifyAll()
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
