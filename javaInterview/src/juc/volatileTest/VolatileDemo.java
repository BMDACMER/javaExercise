package juc.volatileTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1验证volatile的可见性
 *  1.1 如果int num = 0，number变量没有添加volatile关键字修饰
 * 1.2 添加了volatile，可以解决可见性
 *
 * 2.验证volatile不保证原子性
 *  2.1 原子性指的是什么
 *      不可分割、完整性，即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割，需要整体完整，要么同时成功，要么同时失败
 *  2.2 如何解决原子性
 *      2.2.1 方法加synchronized
 *      2.2.2 Atomic
 *
 */
public class VolatileDemo {

    // volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被D修改
    public static void visibilityByVolatile(){
        MyData myData = new MyData();

        // 第一个线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            // 线程暂停3s
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData.addToSixty();
            System.out.println(Thread.currentThread().getName() + "\t update value: " + myData.num);
        }, " Thread1").start();

        //第二个线程是main线程  如果不加volatile,会一直出现转圈圈
        while (myData.num == 0) {
            //如果myData的num一直为零，main线程一直在这里循环
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, num value is " + myData.num);
    }

    // volatile 不保证原子性  可以使用Atomic保证原子性
    public static void atomicByVolatile(){
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                    myData.addSelf();
                    myData.atomicAddSelf();
                }
            },"Thread " + i).start();
        }

        // 等待上面的线程都计算完后，在用main线程取得最终结果值
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (Thread.activeCount() > 2){
            // 默认两个线程 一个为main 一个为gc线程
             Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally num value is " + myData.num);  // < 2000
        System.out.println(Thread.currentThread().getName() + "\t finally num value is " + myData.atomicInteger); // = 2000
    }



    public static void main(String[] args) {
//        visibilityByVolatile();//验证volatile的可见性
        atomicByVolatile();  // 验证原子性
    }

}


class MyData{
//    int num = 0;
    volatile int num = 0;

    public  synchronized void addToSixty() {
        this.num = 60;
    }

    public void addSelf(){
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void atomicAddSelf() {
        atomicInteger.getAndIncrement();
    }
}

class ResortSeq{
    int a = 0;
    boolean flag = false;

    public void method01(){
        a = 1;
        flag = true;
    }
    public void method2(){
        if(flag){
            a = a + 5;
            System.out.println("\"a\" value is "+a);
        }
    }
}

