package juc.base;

import java.util.concurrent.TimeUnit;

/**
 *
 * @Description: 8��
 *
1 ��׼���ʣ��ȴ�ӡ���Ż����ʼ�
2 ͣ4���ڶ��ŷ����ڣ��ȴ�ӡ���Ż����ʼ�
3 ������ͨ��hello���������ȴ���Ż���hello
4 �����������ֻ����ȴ�ӡ���Ż����ʼ�
5 ������̬ͬ��������1���ֻ����ȴ�ӡ���Ż����ʼ�
6 ������̬ͬ��������2���ֻ����ȴ�ӡ���Ż����ʼ�
7 1����̬ͬ������,1����ͨͬ��������1���ֻ����ȴ�ӡ���Ż����ʼ�
8 1����̬ͬ������,1����ͨͬ��������2���ֻ����ȴ�ӡ���Ż����ʼ�
 * ---------------------------------
 *
 */

public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(200);  // 0.2��

        new Thread(() -> {
            phone.sendMSE();
        },"B").start();
    }
}

class Phone {

    public synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread().getName() + "\t" + "���ʼ�");
    }

    public synchronized void sendMSE() {
        System.out.println(Thread.currentThread().getName() + "\t" + "������");
    }

    public void getHello()
    {
        System.out.println("------getHello");
    }

}
