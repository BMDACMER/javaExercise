package juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class ABADemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);   // 初始化值为5
        System.out.println(atomicInteger.compareAndSet(5,2019) + "\t current " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,2020) + "\t current " + atomicInteger.get());
    }
}
