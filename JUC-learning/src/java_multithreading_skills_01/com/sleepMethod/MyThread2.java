package java_multithreading_skills_01.com.sleepMethod;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/23 23:19
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run threadName=" + Thread.currentThread().getName() + " begin="
                    + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run threadName=" + Thread.currentThread().getName() + " end="
            + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
