package java_multithreading_skills_01.com.isAliveMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 15:19
 */
public class CountOperate extends Thread {
    @Override
    public void run() {
        System.out.println("run()-----begin");

        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());

        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());

        System.out.println("run-----end");
    }

    public CountOperate() {
        System.out.println("CountOperate-----begin");

        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());

        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());

        System.out.println("CountOperate----end");
    }
}
