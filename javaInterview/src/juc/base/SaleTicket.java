package juc.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��Ŀ�� ������ƱԱ   ����   30��Ʊ
 *       ���̱߳�̵���ҵ����· + ģ��
 *
 * 1   �ڸ��ھ۵���ϵ�ǰ���£��߳�         ����(���Ⱪ¶�ĵ��÷���)          ��Դ��
 *
 */
public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
//        Thread.State;
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                ticket.saleTicket();
            },"Thread " + String.valueOf(i)).start();

        }
    }

}

class Ticket {   // ��Դ��
    private int number = 30;
    private Lock lock = new ReentrantLock();

    public void saleTicket(){
            lock.lock();
            try {
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + "\t�����ڣ�" + (number--) + "��\t��ʣ��: " + number + "��");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
    }

}
