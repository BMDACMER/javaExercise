package juc.base;

import java.util.concurrent.TimeUnit;

/**
 *
 * @Description: 8锁
 *
1 标准访问，先打印短信还是邮件
2 停4秒在短信方法内，先打印短信还是邮件
3 新增普通的hello方法，是先打短信还是hello
4 现在有两部手机，先打印短信还是邮件
5 两个静态同步方法，1部手机，先打印短信还是邮件
6 两个静态同步方法，2部手机，先打印短信还是邮件
7 1个静态同步方法,1个普通同步方法，1部手机，先打印短信还是邮件
8 1个静态同步方法,1个普通同步方法，2部手机，先打印短信还是邮件
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

        Thread.sleep(200);  // 0.2秒

        new Thread(() -> {
            phone.sendMSE();
        },"B").start();
    }
}

class Phone {

    public synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread().getName() + "\t" + "发邮件");
    }

    public synchronized void sendMSE() {
        System.out.println(Thread.currentThread().getName() + "\t" + "发短信");
    }

    public void getHello()
    {
        System.out.println("------getHello");
    }

}
