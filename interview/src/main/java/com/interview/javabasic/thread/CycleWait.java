package com.interview.javabasic.thread;

public class CycleWait implements Runnable {
    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();

        // 方式一：主线程等待法
//        while (cw.value == null) {
////            Thread.currentThread().sleep(100);
////        }
////
        // 方法二：join
        t.join();
        System.out.println("value : " + cw.value);
    }
}
