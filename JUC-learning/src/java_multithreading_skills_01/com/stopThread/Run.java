package java_multithreading_skills_01.com.stopThread;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/24 9:07
 */
public class Run {
    /*public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        *//*System.out.println("�Ƿ�ֹͣ1��=" + thread.isInterrupted());
        System.out.println("�Ƿ�ֹͣ2��=" + thread.isInterrupted());*//*
        System.out.println("�Ƿ�ֹͣ1��=" + Thread.interrupted());
        System.out.println("�Ƿ�ֹͣ2��=" + Thread.interrupted());
        System.out.println("zzzzzzzzz");
    }*/

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(20);
        myThread.interrupt();

        System.out.println("end!");
    }
}
