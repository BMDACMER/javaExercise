package juc.base;


import juc.lock.CountryEnum;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    public static void main(String[] args) {
//        general();
        try {
            countDownLatchTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void general() {
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t ������ϰ���뿪����");
            },"Thread----->" + i).start();
        }

        while (Thread.activeCount()>2){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "\t============�೤����������");
    }

    public static void countDownLatchTest() throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t����");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t==========��ͳһ");
    }
}
