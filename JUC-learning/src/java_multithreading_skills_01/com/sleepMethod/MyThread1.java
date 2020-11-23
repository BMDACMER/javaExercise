package java_multithreading_skills_01.com.sleepMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 23:11
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("run threadName=" + this.currentThread().getName() + " begin");
            Thread.sleep(2000);
            System.out.println("run threadName=" + this.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
