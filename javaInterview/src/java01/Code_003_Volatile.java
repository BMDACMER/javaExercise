package java01;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number = 0;
//    int number = 0;

    public void addT060(){
        this.number = 60;
    }

    // ��ע�⣺��ʱnumberǰ���Ǽ���volatile�ؼ�������
    public void  addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}

/**
 *1 ��֤volatile�Ŀɼ���
 *    1.1 ���� int number = 0;  number����֮ǰ����û�����volatile�ؼ������Σ�û�пɼ���
 *    1.2 �����volatile�����Խ���ɼ�������
 *
 * 2 ��֤volatile����֤ԭ����
 *   2.1 ԭ������ʲô��˼��
 *       ���ɷָ�����ԣ�Ҳ��ĳ���߳�������ĳ������ҵ��ʱ���м䲻���Ա����ػ��߱��ָ��Ҫ��������
 *       Ҫôͬʱ�ɹ���Ҫôͬʱʧ��
 *   2.2 volatile����֤ԭ���Եİ�����ʾ
 *   2.3 why
 *   2.4 ��ν��ԭ���ԣ�
 *      * ��syn
 *      * ʹ��JUC��AtomicInteger
 *
 *
 *
 */
public class Code_003_Volatile {
    // volatile���Ա�֤�ɼ��ԣ���ʱ֪ͨ�����̣߳��������ڴ��ֵ�Ѿ����޸�
    @Test
    public void seeOkByVolatile(){
        MyData myData = new MyData();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // ��ͣ��
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addT060();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);
        },"AAA").start();

        while (myData.number == 0){
            // main�߳̾�һֱ�������ȴ�ѭ����ֱ��numberֵ���ڵ�����
        }

        System.out.println(Thread.currentThread().getName() + "\t miss is over");
    }

    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; ++i){
            new Thread(() -> {
                for (int j = 0; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // ��Ҫ�ȴ�����20���߳�ȫ��������ɺ�����main�߳�ȡ�����յĽ��ֵ���Ƕ��٣�
        // ��ͣһ���߳�
        while (Thread.activeCount() > 2){   // Ĭ�������߳� һ��Ϊmain һ��Ϊgc�߳�
            Thread.yield();
        }

        // main �߳�
        System.out.println(Thread.currentThread().getName() +
                " \t int finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + " \t AtomicInteger type, " +
                " finally number value: " + myData.atomicInteger);
    }


}
