package juc.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ���߳�֮�䰴˳����ã�ʵ��A--> B --> C
 * �����߳�������Ҫ�����£�
 *
 * AA��ӡ5�Σ�BB��ӡ10�Σ�CC��ӡ15��
 * ����
 * AA��ӡ5�Σ�BB��ӡ10�Σ�CC��ӡ15��
 * ��������10��
 *
 * 1   ����۵����ǰ���£��̲߳�����Դ��
 * 2   �ж�/�ɻ�/֪ͨ
 * 3   ���߳̽����У�����Ҫ��ֹ���̵߳���ٻ��� ���ж�ֻ����while��������if��
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}

class ShareResource {
    private int number = 1;  // 1:A  2:B  3:C
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 1 �ж�
            while (number != 1) {
                condition1.await();
            }
            // 2 �ɻ�
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3 ֪ͨ
            number = 2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10() {
        lock.lock();
        try {
            // 1 �ж�
            while (number != 2) {
                condition2.await();
            }
            // 2 �ɻ�
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3 ֪ͨ
            number = 3;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15() {
        lock.lock();
        try {
            // 1 �ж�
            while (number != 3) {
                condition3.await();
            }
            // 2 �ɻ�
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3 ֪ͨ
            number = 1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}