package juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *  ABA������
 * AtomicStampedReference
 */
public class ABADemo2 {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args){
        System.out.println("============������ABA����Ĳ���==============");
        new Thread(()->{
            // ���ĺ��ڸĻ���
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"Thread 1 ").start();

        new Thread(()->{
            // ��֤�߳�1���һ��ABA����
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100,2020) + "\t " + atomicReference.get());
        }, "Thread 2 ").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==========������ABA����Ľ��==============");

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t��1�ΰ汾��" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t��2�ΰ汾��" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t��3�ΰ汾��" + atomicStampedReference.getStamp());
        },"Thread 3").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t��1�ΰ汾��" + stamp);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);

            System.out.println(Thread.currentThread().getName() + "\t�޸��Ƿ�ɹ�" + result + "\t��ǰ����ʵ�ʰ汾�ţ�" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t��ǰ����ʵ��ֵ��" + atomicStampedReference.getReference());
        }, "Thread 4").start();
    }

}
