package leetcode;

import java.util.concurrent.CountDownLatch;

/**
 *  * CountDownLatch��Ҫ��������������һ�������̵߳���await����ʱ����Щ�̻߳�������
 *  * �����̵߳���countDown�����Ὣ��������1(����countDown�������̲߳�������)��
 *  * ����������ֵ��Ϊ0ʱ����await�����������̻߳ᱻ���ѣ�����ִ�С�
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            // 6������ϰ��ͬѧ�������뿪���ҵ�ʱ�䲻һ��
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t ��ͬѧ�뿪����");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t*******�೤�������ˣ�main�߳��ǰ೤");
    }

}
