package juc.volatileTest;

import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) {
        visibilityByVolatile();//��֤volatile�Ŀɼ���
    }
    /**
     * volatile���Ա�֤�ɼ��ԣ���ʱ֪ͨ�����̣߳��������ڴ��ֵ�Ѿ����޸�
     */
    public static void visibilityByVolatile() {
        MyData myData = new MyData();
//��һ���߳�
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
//�߳���ͣ3s
                TimeUnit.SECONDS.sleep(3);
                myData.addToSixty();
                System.out.println(Thread.currentThread().getName() + "\t update value:" + myData.num);
            } catch (Exception e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, "thread1").start();
//�ڶ����߳���main�߳�
        while (myData.num == 0) {
//���myData��numһֱΪ�㣬main�߳�һֱ������ѭ��
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, num value is " + myData.num);
    }
}

