package juc.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目： 三个售票员   卖出   30张票
 *       多线程编程的企业级套路 + 模板
 *
 * 1   在高内聚低耦合的前提下，线程         操作(对外暴露的调用方法)          资源类
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

class Ticket {   // 资源类
    private int number = 30;
    private Lock lock = new ReentrantLock();

    public void saleTicket(){
            lock.lock();
            try {
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "张\t还剩下: " + number + "张");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
    }

}
