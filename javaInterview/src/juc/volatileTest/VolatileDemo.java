package juc.volatileTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1��֤volatile�Ŀɼ���
 *  1.1 ���int num = 0��number����û�����volatile�ؼ�������
 * 1.2 �����volatile�����Խ���ɼ���
 *
 * 2.��֤volatile����֤ԭ����
 *  2.1 ԭ����ָ����ʲô
 *      ���ɷָ�����ԣ���ĳ���߳�������ĳ������ҵ��ʱ���м䲻���Ա��������߱��ָ��Ҫ����������Ҫôͬʱ�ɹ���Ҫôͬʱʧ��
 *  2.2 ��ν��ԭ����
 *      2.2.1 ������synchronized
 *      2.2.2 Atomic
 *
 */
public class VolatileDemo {

    // volatile���Ա�֤�ɼ��ԣ���ʱ֪ͨ�����̣߳��������ڴ��ֵ�Ѿ���D�޸�
    public static void visibilityByVolatile(){
        MyData myData = new MyData();

        // ��һ���߳�
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            // �߳���ͣ3s
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData.addToSixty();
            System.out.println(Thread.currentThread().getName() + "\t update value: " + myData.num);
        }, " Thread1").start();

        //�ڶ����߳���main�߳�  �������volatile,��һֱ����תȦȦ
        while (myData.num == 0) {
            //���myData��numһֱΪ�㣬main�߳�һֱ������ѭ��
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, num value is " + myData.num);
    }

    // volatile ����֤ԭ����  ����ʹ��Atomic��֤ԭ����
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

        // �ȴ�������̶߳������������main�߳�ȡ�����ս��ֵ
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (Thread.activeCount() > 2){
            // Ĭ�������߳� һ��Ϊmain һ��Ϊgc�߳�
             Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally num value is " + myData.num);  // < 2000
        System.out.println(Thread.currentThread().getName() + "\t finally num value is " + myData.atomicInteger); // = 2000
    }



    public static void main(String[] args) {
//        visibilityByVolatile();//��֤volatile�Ŀɼ���
        atomicByVolatile();  // ��֤ԭ����
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

