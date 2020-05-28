package com.interview.javabasic.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread1");
        MyThread t2 = new MyThread("Thread2");
        MyThread t3 = new MyThread("Thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
